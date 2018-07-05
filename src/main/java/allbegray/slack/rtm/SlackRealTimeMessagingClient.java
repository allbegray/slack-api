package allbegray.slack.rtm;

import allbegray.slack.exception.SlackException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.BoundRequestBuilder;
import org.asynchttpclient.proxy.ProxyServer;
import org.asynchttpclient.ws.WebSocketListener;
import org.asynchttpclient.ws.WebSocket;
import org.asynchttpclient.ws.WebSocketUpgradeHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.asynchttpclient.Dsl.*;

public class SlackRealTimeMessagingClient {

	private static Log logger = LogFactory.getLog(SlackRealTimeMessagingClient.class);

	private String webSocketUrl;
	private ProxyServerInfo proxyServerInfo;
	private AsyncHttpClient asyncHttpClient;
	private WebSocket webSocket;
	private Map<String, List<EventListener>> listeners = new HashMap<String, List<EventListener>>();
	private List<CloseListener> closeListeners = new ArrayList<CloseListener>();
	private List<FailureListener> failureListeners = new ArrayList<FailureListener>();
	private boolean stop;
	private ObjectMapper mapper;
	private Integer pingMillis;

	public SlackRealTimeMessagingClient(String webSocketUrl) {
		this(webSocketUrl, null, null, null);
	}

	public SlackRealTimeMessagingClient(String webSocketUrl, ProxyServerInfo proxyServerInfo) {
		this(webSocketUrl, null, null, proxyServerInfo);
	}

	public SlackRealTimeMessagingClient(String webSocketUrl, ObjectMapper mapper) {
		this(webSocketUrl, mapper, null, null);
	}

	public SlackRealTimeMessagingClient(String webSocketUrl, ObjectMapper mapper, ProxyServerInfo proxyServerInfo) {
		this(webSocketUrl, mapper, null, proxyServerInfo);
	}

	public SlackRealTimeMessagingClient(String webSocketUrl, Integer pingMillis) {
		this(webSocketUrl, null, pingMillis, null);
	}

	public SlackRealTimeMessagingClient(String webSocketUrl, Integer pingMillis, ProxyServerInfo proxyServerInfo) {
		this(webSocketUrl, null, pingMillis, proxyServerInfo);
	}

	public SlackRealTimeMessagingClient(String webSocketUrl, ObjectMapper mapper, Integer pingMillis, ProxyServerInfo proxyServerInfo) {
		if (mapper == null) {
			mapper = new ObjectMapper();
		}
		if (pingMillis == null) {
			pingMillis = 3 * 1000;
		}
		this.webSocketUrl = webSocketUrl;
		this.proxyServerInfo = proxyServerInfo;
		this.mapper = mapper;
		this.pingMillis = pingMillis;
	}

	public void addListener(Event event, EventListener listener) {
		addListener(event.name().toLowerCase(), listener);
	}

	public void addListener(String event, EventListener listener) {
		List<EventListener> eventListeners = listeners.get(event);
		if (eventListeners == null) {
			eventListeners = new ArrayList<EventListener>();
			listeners.put(event, eventListeners);
		}
		eventListeners.add(listener);
	}

	public void addCloseListener(CloseListener listener) {
		closeListeners.add(listener);
	}

	public void addFailureListener(FailureListener listener) {
		failureListeners.add(listener);
	}

	public void close() {
		logger.info("Slack RTM closing...");

		stop = true;
		if (webSocket != null && webSocket.isOpen()) {
			webSocket.sendCloseFrame();
		}
		if (asyncHttpClient != null && !asyncHttpClient.isClosed()) {
			try {
				asyncHttpClient.close();
			} catch (IOException e) {
				// ignore
			}
		}

		logger.info("Slack RTM closed.");
	}

	public boolean connect() {
		try {
			if (proxyServerInfo != null) {
				ProxyServer.Builder proxyServer = proxyServer(proxyServerInfo.getHost(), proxyServerInfo.getPort());
				if (proxyServerInfo.getPrincipal() != null && proxyServerInfo.getPassword() != null) {
					proxyServer = proxyServer.setRealm(basicAuthRealm(proxyServerInfo.getPrincipal(), proxyServerInfo.getPassword()));
				}
				asyncHttpClient = asyncHttpClient(config().setProxyServer(proxyServer));
			} else {
				asyncHttpClient = asyncHttpClient();
			}
			BoundRequestBuilder requestBuilder = asyncHttpClient.prepareGet(webSocketUrl);
			webSocket = requestBuilder.execute(new WebSocketUpgradeHandler.Builder().addWebSocketListener(new WebSocketListener() {

				@Override
				public void onTextFrame(String message, boolean finalFragment, int rsv) {
					String type = null;
					JsonNode node = null;
					try {
						node = mapper.readTree(message);
						type = node.findPath("type").asText();
					} catch (Exception e) {
						logger.error(e);
					}

					if (!"pong".equals(type)) {
						logger.info("Slack RTM message : " + message);
					}

					if (type != null) {
						List<EventListener> eventListeners = listeners.get(type);
						if (eventListeners != null && !eventListeners.isEmpty()) {
							for (EventListener listener : eventListeners) {
								listener.onMessage(node);
							}
						}
					}
				}

				@Override
				public void onClose(WebSocket websocket, int code, String reason) {
					stop = true;
					if (closeListeners != null && !closeListeners.isEmpty()) {
						for (CloseListener listener : closeListeners) {
							listener.onClose();
						}
					}
				}

				@Override
				public void onError(Throwable t) {
					stop = true;
					t.printStackTrace();
					if (failureListeners != null && !failureListeners.isEmpty()) {
						for (FailureListener listener : failureListeners) {
							listener.onFailure(new SlackException(t));
						}
					}
				}

				@Override
				public void onOpen(WebSocket arg0) {
				}

			}).build()).get();

			logger.info("connected Slack RTM(Real Time Messaging) server : " + webSocketUrl);

			await();

		} catch (Exception e) {
			close();
			throw new SlackException(e);
		}
		return true;
	}

	private long socketId = 0;

	private void ping() {
		ObjectNode pingMessage = mapper.createObjectNode();
		pingMessage.put("id", ++socketId);
		pingMessage.put("type", "ping");
		String pingJson = pingMessage.toString();
		webSocket.sendTextFrame(pingJson);

		logger.debug("ping : " + pingJson);
	}

	private void await() {
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(pingMillis);
					while (!stop) {
						ping();
						Thread.sleep(pingMillis);
					}
				} catch (Exception e) {
					throw new SlackException(e);
				}
			}
		});
		thread.start();
	}

	/**
	 * This method sends message to slack using webSocket client
	 * @param message
	 */
	public void sendMessage(String message){
		webSocket.sendTextFrame(message);
	}

	/**
	 * This method returns the webSocket connected with Slack RTM
	 * @return the webSocket client object
	 */
	public WebSocket getWebsocket(){
		return webSocket;
	}

}
