package flowctrl.integration.slack;

import org.junit.Test;

import flowctrl.integration.slack.rtm.ProxyServerInfo;
import flowctrl.integration.slack.rtm.SlackRealTimeMessagingClient;

public class SlackRealTimeMessagingClientTest {

	private String token = "your slack web api token";

	@Test(timeout = 60 * 1000)
	public void basicTest() {
		SlackRealTimeMessagingClient realTimeMessagingClient = SlackClientFactory.createSlackRealTimeMessagingClient(token);
		realTimeMessagingClient.addListener("hello", new HelloEventListener());
		realTimeMessagingClient.addListener("message", new MessageEventListener());
		realTimeMessagingClient.connect();
	}

	@Test(timeout = 60 * 1000)
	public void proxyTest() {
		String protocol = "https";
		String proxyUrl = "xxx.xxx.xxx.xxx";
		int proxyPort = 1234;

		ProxyServerInfo proxyServerInfo = new ProxyServerInfo(protocol, proxyUrl, proxyPort);

		SlackRealTimeMessagingClient realTimeMessagingClient = SlackClientFactory.createSlackRealTimeMessagingClient(token, proxyServerInfo);
		realTimeMessagingClient.addListener("hello", new HelloEventListener());
		realTimeMessagingClient.connect();
	}

}
