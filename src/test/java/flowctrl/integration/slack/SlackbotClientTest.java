package flowctrl.integration.slack;

import org.junit.Before;
import org.junit.Test;

import flowctrl.integration.slack.bot.SlackbotClient;

public class SlackbotClientTest {

	private String slackbotUrl = "https://{yourteam}.slack.com/services/hooks/slackbot?token={token}";
	private SlackbotClient slackbotClient;

	@Before
	public void setup() {
		slackbotClient = SlackClientFactory.createSlackbotClient(slackbotUrl);
	}

	@Test
	public void basicTest() {
		slackbotClient.post("#channelName", "test message 1");
		slackbotClient.post("@userName", "test message 2");
	}

}
