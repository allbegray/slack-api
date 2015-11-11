package flowctrl.integration.slack;

import org.junit.Test;

import flowctrl.integration.slack.rtm.ProxyServerInfo;
import flowctrl.integration.slack.rtm.SlackRealTimeMessagingClient;

public class SlackRealTimeMessagingClientTest {

	private String token = "your slack web api token";

	@Test
	public void basicTest() {
		SlackRealTimeMessagingClient realTimeMessagingClient = SlackClientFactory.createSlackRealTimeMessagingClient(token);
		realTimeMessagingClient.addListener("hello", new HelloEventListener());
		realTimeMessagingClient.addListener("message", new MessageEventListener());
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
