package allbegray.slack;

import allbegray.slack.rtm.ProxyServerInfo;
import allbegray.slack.rtm.SlackRealTimeMessagingClient;

public class SlackRealTimeMessagingClientProxyTest {

    private static String token = "your slack web api token";

    public static void main(String args[]) {
        String protocol = "https";
        String proxyHost = "xxx.xxx.xxx.xxx";
        int proxyPort = 1234;

        ProxyServerInfo proxyServerInfo = new ProxyServerInfo(protocol, proxyHost, proxyPort);

        SlackRealTimeMessagingClient realTimeMessagingClient = SlackClientFactory.createSlackRealTimeMessagingClient(token, proxyServerInfo);
        realTimeMessagingClient.addListener("hello", new HelloEventListener());
        realTimeMessagingClient.connect();

        try {
            Thread.sleep(60 * 1000);
            realTimeMessagingClient.close();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
