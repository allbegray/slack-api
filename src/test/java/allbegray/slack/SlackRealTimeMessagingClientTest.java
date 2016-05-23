package allbegray.slack;

import org.junit.Test;

import com.fasterxml.jackson.databind.JsonNode;

import allbegray.slack.rtm.Event;
import allbegray.slack.rtm.EventListener;
import allbegray.slack.rtm.ProxyServerInfo;
import allbegray.slack.rtm.SlackRealTimeMessagingClient;

public class SlackRealTimeMessagingClientTest {

	private String token = "your slack web api token";

	@Test
	public void basicTest() {
		SlackRealTimeMessagingClient realTimeMessagingClient = SlackClientFactory.createSlackRealTimeMessagingClient(token);
		realTimeMessagingClient.addListener("hello", new HelloEventListener());
		realTimeMessagingClient.addListener("message", new MessageEventListener());
		realTimeMessagingClient.addListener(Event.MESSAGE, new EventListener() {
			@Override
			public void handleMessage(JsonNode message) {
				// todo
			}
		});
		realTimeMessagingClient.connect();
		
		try {
			Thread.sleep(60 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void proxyTest() {
		String protocol = "https";
		String proxyHost = "xxx.xxx.xxx.xxx";
		int proxyPort = 1234;

		ProxyServerInfo proxyServerInfo = new ProxyServerInfo(protocol, proxyHost, proxyPort);

		SlackRealTimeMessagingClient realTimeMessagingClient = SlackClientFactory.createSlackRealTimeMessagingClient(token, proxyServerInfo);
		realTimeMessagingClient.addListener("hello", new HelloEventListener());
		realTimeMessagingClient.connect();
		
		try {
			Thread.sleep(60 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
