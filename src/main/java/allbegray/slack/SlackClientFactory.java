package allbegray.slack;

import allbegray.slack.bot.SlackbotClient;
import allbegray.slack.rtm.ProxyServerInfo;
import allbegray.slack.rtm.SlackRealTimeMessagingClient;
import allbegray.slack.webapi.SlackWebApiClient;
import allbegray.slack.webapi.SlackWebApiClientImpl;
import allbegray.slack.webhook.SlackWebhookClient;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class SlackClientFactory {

	// web api

	public static SlackWebApiClient createWebApiClient(String token, String userToken) {
		return new SlackWebApiClientImpl(token, userToken);
	}

	public static SlackWebApiClient createWebApiClient(String token, String userToken, ProxyServerInfo proxyServerInfo) {
		return new SlackWebApiClientImpl(token, userToken, proxyServerInfo);
	}

	public static SlackWebApiClient createWebApiClient(String token, String userToken, ObjectMapper mapper) {
		return new SlackWebApiClientImpl(token, userToken, mapper);
	}

	public static SlackWebApiClient createWebApiClient(String token, String userToken, ObjectMapper mapper, ProxyServerInfo proxyServerInfo) {
		return new SlackWebApiClientImpl(token, userToken, mapper, proxyServerInfo);
	}

	public static SlackWebApiClient createWebApiClient(String token, String userToken, ObjectMapper mapper, int timeout) {
		return new SlackWebApiClientImpl(token, userToken, mapper, timeout);
	}

	public static SlackWebApiClient createWebApiClient(String token, String userToken, ObjectMapper mapper, int timeout, ProxyServerInfo proxyServerInfo) {
		return new SlackWebApiClientImpl(token, userToken, mapper, timeout, proxyServerInfo);
	}

	// webhook

	public static SlackWebhookClient createWebhookClient(String webhookUrl) {
		return new SlackWebhookClient(webhookUrl);
	}

	public static SlackWebhookClient createWebhookClient(String webhookUrl, ProxyServerInfo proxyServerInfo) {
		return new SlackWebhookClient(webhookUrl, proxyServerInfo);
	}

	public static SlackWebhookClient createWebhookClient(String webhookUrl, ObjectMapper mapper) {
		return new SlackWebhookClient(webhookUrl, mapper);
	}

	public static SlackWebhookClient createWebhookClient(String webhookUrl, ObjectMapper mapper, ProxyServerInfo proxyServerInfo) {
		return new SlackWebhookClient(webhookUrl, mapper, proxyServerInfo);
	}

	public static SlackWebhookClient createWebhookClient(String webhookUrl, ObjectMapper mapper, int timeout) {
		return new SlackWebhookClient(webhookUrl, mapper, timeout);
	}

	public static SlackWebhookClient createWebhookClient(String webhookUrl, ObjectMapper mapper, int timeout, ProxyServerInfo proxyServerInfo) {
		return new SlackWebhookClient(webhookUrl, mapper, timeout, proxyServerInfo);
	}

	// slackbot

	public static SlackbotClient createSlackbotClient(String slackbotUrl) {
		return new SlackbotClient(slackbotUrl);
	}

	public static SlackbotClient createSlackbotClient(String slackbotUrl, ProxyServerInfo proxyServerInfo) {
		return new SlackbotClient(slackbotUrl, proxyServerInfo);
	}

	public static SlackbotClient createSlackbotClient(String slackbotUrl, int timeout) {
		return new SlackbotClient(slackbotUrl, timeout);
	}

	public static SlackbotClient createSlackbotClient(String slackbotUrl, int timeout, ProxyServerInfo proxyServerInfo) {
		return new SlackbotClient(slackbotUrl, timeout, proxyServerInfo);
	}

	// rtm

	public static SlackRealTimeMessagingClient createSlackRealTimeMessagingClient(String token) {
		return createSlackRealTimeMessagingClient(token, null, null);
	}

	public static SlackRealTimeMessagingClient createSlackRealTimeMessagingClient(String token, ProxyServerInfo proxyServerInfo) {
		return createSlackRealTimeMessagingClient(token, null, proxyServerInfo);
	}

	public static SlackRealTimeMessagingClient createSlackRealTimeMessagingClient(String token, ObjectMapper mapper) {
		return createSlackRealTimeMessagingClient(token, mapper, null);
	}

	public static SlackRealTimeMessagingClient createSlackRealTimeMessagingClient(String token, ObjectMapper mapper, ProxyServerInfo proxyServerInfo) {
		SlackWebApiClient webApiClient = createWebApiClient(token, null, proxyServerInfo);
		String webSocketUrl = webApiClient.startRealTimeMessagingApi().findPath("url").asText();
		return new SlackRealTimeMessagingClient(webSocketUrl, mapper, proxyServerInfo);
	}

}
