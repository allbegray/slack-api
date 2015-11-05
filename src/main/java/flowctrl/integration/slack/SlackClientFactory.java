package flowctrl.integration.slack;

import com.fasterxml.jackson.databind.ObjectMapper;

import flowctrl.integration.slack.bot.SlackbotClient;
import flowctrl.integration.slack.webapi.SlackWebApiClient;
import flowctrl.integration.slack.webhook.SlackWebhookClient;

public abstract class SlackClientFactory {

	// web api

	public static SlackWebApiClient createWebApiClient(String token) {
		return new SlackWebApiClient(token);
	}

	public static SlackWebApiClient createWebApiClient(String token, ObjectMapper mapper) {
		return new SlackWebApiClient(token, mapper);
	}

	public static SlackWebApiClient createWebApiClient(String token, ObjectMapper mapper, int timeout) {
		return new SlackWebApiClient(token, mapper, timeout);
	}

	// webhook

	public static SlackWebhookClient createWebhookClient(String webhookUrl) {
		return new SlackWebhookClient(webhookUrl);
	}

	public static SlackWebhookClient createWebhookClient(String webhookUrl, ObjectMapper mapper) {
		return new SlackWebhookClient(webhookUrl, mapper);
	}

	public static SlackWebhookClient createWebhookClient(String webhookUrl, ObjectMapper mapper, int timeout) {
		return new SlackWebhookClient(webhookUrl, mapper, timeout);
	}

	// slackbot

	public static SlackbotClient createSlackbotClient(String slackbotUrl) {
		return new SlackbotClient(slackbotUrl);
	}

	public static SlackbotClient createSlackbotClient(String slackbotUrl, int timeout) {
		return new SlackbotClient(slackbotUrl, timeout);
	}

}
