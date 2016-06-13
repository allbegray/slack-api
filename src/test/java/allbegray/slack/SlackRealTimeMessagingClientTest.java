package allbegray.slack;

import allbegray.slack.rtm.Event;
import allbegray.slack.rtm.EventListener;
import allbegray.slack.rtm.SlackRealTimeMessagingClient;
import com.fasterxml.jackson.databind.JsonNode;

public class SlackRealTimeMessagingClientTest {

    private static String token = "your slack web api token";

    public static void main(String args[]) {
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
            realTimeMessagingClient.close();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
