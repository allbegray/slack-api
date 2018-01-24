package allbegray.slack.webapi.method.chats;

import allbegray.slack.SlackClientFactory;
import allbegray.slack.webapi.SlackWebApiClient;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by allbegray on 2016-06-14.
 */
public class ChatMeMessageMethodTest {

    private String token = "your slack web api token";
    private String userToken = "install user token";
    private SlackWebApiClient webApiClient;

    @Before
    public void setup() {
        webApiClient = SlackClientFactory.createWebApiClient(token, userToken);
    }

    @Test
    public void infoTest() {
        webApiClient.meMessage("C07GVMHCH", "test");
    }

}