package allbegray.slack.webapi.method.chats;

import allbegray.slack.SlackClientFactory;
import allbegray.slack.exception.SlackArgumentException;
import allbegray.slack.webapi.SlackWebApiClient;
import org.junit.Before;
import org.junit.Test;

public class ChatPostMessageMethodTest {

    private static final String CHANNEL = "<your channel>";
    private static final String TOKEN = "<your slack web api token>";
    private SlackWebApiClient webApiClient;

    @Before
    public void setup() {
        webApiClient = SlackClientFactory.createWebApiClient(TOKEN);
    }

    @Test
    public void shouldBroadcastReply() {
        String ts = webApiClient.postMessage(CHANNEL, "broadcast test");
        ChatPostMessageMethod chatPostMessageMethod = new ChatPostMessageMethod(CHANNEL, "broadcast test reply");
        chatPostMessageMethod.setThread_ts(ts);
        chatPostMessageMethod.setReplyBroadcast(true);
        webApiClient.postMessage(chatPostMessageMethod);
    }

    @Test(expected = SlackArgumentException.class)
    public void shouldFailToBroadcastReplyIfNoParentMessage() {
        ChatPostMessageMethod chatPostMessageMethod = new ChatPostMessageMethod(CHANNEL, "broadcast test reply");
        chatPostMessageMethod.setReplyBroadcast(true);
        webApiClient.postMessage(chatPostMessageMethod);
    }

    @Test
    public void shouldPostReply() {
        String ts = webApiClient.postMessage(CHANNEL, "post message test");
        ChatPostMessageMethod chatPostMessageMethod = new ChatPostMessageMethod(CHANNEL, "post message reply");
        chatPostMessageMethod.setThread_ts(ts);
        webApiClient.postMessage(chatPostMessageMethod);
    }
}
