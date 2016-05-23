package allbegray.slack;

import allbegray.slack.bot.SlackbotClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SlackbotClientTest {

	private String slackbotUrl = "https://{yourteam}.slack.com/services/hooks/slackbot?token={token}";
	private SlackbotClient slackbotClient;

	@Before
	public void setup() {
		slackbotClient = SlackClientFactory.createSlackbotClient(slackbotUrl);
	}

	@After
	public void shutdown() {
		slackbotClient.shutdown();
	}

	@Test
	public void basicTest() {
		slackbotClient.post("#channelName", "test message 1");
		slackbotClient.post("@userName", "test message 2");
	}

}
