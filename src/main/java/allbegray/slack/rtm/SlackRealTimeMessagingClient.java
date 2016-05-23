package allbegray.slack.rtm;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import allbegray.slack.exception.SlackException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.LongNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.AsyncHttpClient.BoundRequestBuilder;
import com.ning.http.client.AsyncHttpClientConfig;
import com.ning.http.client.AsyncHttpClientConfig.Builder;
import com.ning.http.client.ProxyServer;
import com.ning.http.client.ProxyServer.Protocol;
import com.ning.http.client.ws.DefaultWebSocketListener;
import com.ning.http.client.ws.WebSocket;
import com.ning.http.client.ws.WebSocketUpgradeHandler;

public class SlackRealTimeMessagingClient {

	private static Log logger = LogFactory.getLog(SlackRealTimeMessagingClient.class);

	private String webSocketUrl;
	private ProxyServerInfo proxyServerInfo;
	private AsyncHttpClient asyncHttpClient;
	private WebSocket webSocket;
	private Map<String, List<EventListener>> listeners = new HashMap<String, List<EventListener>>();
	private boolean stop;
	private ObjectMapper mapper;

	public SlackRealTimeMessagingClient(String webSocketUrl, ObjectMapper mapper) {
		this(webSocketUrl, null, mapper);
	}

	public SlackRealTimeMessagingClient(String webSocketUrl, ProxyServerInfo proxyServerInfo, ObjectMapper mapper) {
		if (mapper == null) {
			mapper = new ObjectMapper();
		}
		this.webSocketUrl = webSocketUrl;
		this.proxyServerInfo = proxyServerInfo;
		this.mapper = mapper;
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

	public void close() {
		stop = true;
		if (webSocket != null && webSocket.isOpen()) {
			webSocket.close();
		}
		if (asyncHttpClient != null && !asyncHttpClient.isClosed()) {
			asyncHttpClient.close();
		}
	}

	public boolean connect() {

		Builder builder = new AsyncHttpClientConfig.Builder();
		if (proxyServerInfo != null) {
			Protocol protocol = null;
			for (Protocol p : Protocol.values()) {
				if (p.getProtocol().equalsIgnoreCase(proxyServerInfo.getProtocol())) {
					protocol = p;
				}
			}
			if (protocol == null) {
				protocol = Protocol.HTTP;
			}

			builder.setProxyServer(new ProxyServer(protocol, proxyServerInfo.getHost(), proxyServerInfo.getPort()));
			builder.setUseProxyProperties(true);
		}

		AsyncHttpClientConfig clientConfig = builder.build();
		asyncHttpClient = new AsyncHttpClient(clientConfig);
		BoundRequestBuilder requestBuilder = asyncHttpClient.prepareGet(webSocketUrl);
		try {
			webSocket = requestBuilder.execute(new WebSocketUpgradeHandler.Builder().addWebSocketListener(new DefaultWebSocketListener() {

				@Override
				public void onClose(WebSocket websocket) {
					super.onClose(websocket);
					stop = true;
				}

				@Override
				public void onPing(byte[] message) {
					ObjectNode pongMessage = mapper.createObjectNode();
					pongMessage.set("type", TextNode.valueOf("pong"));
					pongMessage.set("time", LongNode.valueOf(new Date().getTime()));
					
					logger.info("pong message : " + pongMessage);
					
					webSocket.sendPong(pongMessage.toString().getBytes());
				}
				
				@Override
				public void onError(Throwable t) {
					throw new SlackException(t);
				}

				@Override
				public void onMessage(String message) {
					logger.info("Slack RTM message : " + message);

					String type = null;
					JsonNode node = null;
					try {
						node = mapper.readTree(message);
						type = node.findPath("type").asText();
					} catch (Exception e) {
						logger.error(e);
					}

					if (type != null) {
						List<EventListener> eventListeners = listeners.get(type);
						if (eventListeners != null && !eventListeners.isEmpty()) {
							for (EventListener listener : eventListeners) {
								listener.handleMessage(node);
							}
						}
					}
				}

			}).build()).get();

			logger.info("connected Slack RTM(Real Time Messaging) server : " + webSocketUrl);

			await();

		} catch (Exception e) {
			throw new SlackException(e);
		}

		return true;
	}

	private void await() {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				while (!stop) {
					try {
						Thread.sleep(5 * 1000);
					} catch (Exception e) {
						throw new SlackException(e);
					}
				}
			}
		});
		thread.start();
	}

}
