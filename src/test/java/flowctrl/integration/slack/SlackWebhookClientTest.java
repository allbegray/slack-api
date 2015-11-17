package flowctrl.integration.slack;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import flowctrl.integration.slack.type.Attachment;
import flowctrl.integration.slack.type.Field;
import flowctrl.integration.slack.type.Payload;
import flowctrl.integration.slack.webhook.SlackWebhookClient;

public class SlackWebhookClientTest {

	private String webhookUrl = "https://hooks.slack.com/services/{id_1}/{id_2}/{token}";
	private SlackWebhookClient webhookClient;

	@Before
	public void setup() {
		webhookClient = SlackClientFactory.createWebhookClient(webhookUrl);
	}

	@After
	public void shutdown() {
		webhookClient.shutdown();
	}

	@Test
	public void basicTest() {

		Payload payload = new Payload();
		payload.setText("test text");
		payload.setChannel("#general");
		payload.setUsername("send user");
		payload.setIcon_emoji(":octocat:");

		Attachment attachment = new Attachment();
		attachment.setTitle("test attachment title");
		attachment.setColor("good");
		attachment.setText("test attachment text");
		attachment.addField(new Field("test field title 1", "test field value 1"));
		attachment.addField(new Field("test field title 2", "test field value 2"));
		payload.addAttachment(attachment);

		webhookClient.post(payload);

	}

}
