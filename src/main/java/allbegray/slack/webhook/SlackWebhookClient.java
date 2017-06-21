package allbegray.slack.webhook;

import allbegray.slack.RestUtils;
import allbegray.slack.exception.SlackArgumentException;
import allbegray.slack.exception.SlackException;
import allbegray.slack.rtm.ProxyServerInfo;
import allbegray.slack.type.Payload;
import allbegray.slack.webapi.SlackWebApiConstants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.impl.client.CloseableHttpClient;

import java.util.HashMap;
import java.util.Map;

public class SlackWebhookClient {

	private String webhookUrl;
	private ObjectMapper mapper;
	private CloseableHttpClient httpClient;

	public SlackWebhookClient(String webhookUrl) {
		this(webhookUrl, null, SlackWebApiConstants.DEFAULT_TIMEOUT, null);
	}

	public SlackWebhookClient(String webhookUrl, ProxyServerInfo proxyServerInfo) {
		this(webhookUrl, null, SlackWebApiConstants.DEFAULT_TIMEOUT, proxyServerInfo);
	}

	public SlackWebhookClient(String webhookUrl, ObjectMapper mapper) {
		this(webhookUrl, mapper, SlackWebApiConstants.DEFAULT_TIMEOUT, null);
	}

	public SlackWebhookClient(String webhookUrl, ObjectMapper mapper, ProxyServerInfo proxyServerInfo) {
		this(webhookUrl, mapper, SlackWebApiConstants.DEFAULT_TIMEOUT, proxyServerInfo);
	}

	public SlackWebhookClient(String webhookUrl, ObjectMapper mapper, int timeout) {
		this(webhookUrl, mapper, timeout, null);
	}

	public SlackWebhookClient(String webhookUrl, ObjectMapper mapper, int timeout, ProxyServerInfo proxyServerInfo) {
		if (webhookUrl == null) {
			throw new SlackArgumentException("Missing WebHook URL Configuration @ SlackApi");

		} else if (!webhookUrl.startsWith("https://hooks.slack.com/services/")) {
			throw new SlackArgumentException("Invalid Service URL. WebHook URL Format: https://hooks.slack.com/services/{id_1}/{id_2}/{token}");
		}

		this.webhookUrl = webhookUrl;
		this.mapper = mapper != null ? mapper : new ObjectMapper();
		httpClient = proxyServerInfo != null ? RestUtils.createHttpClient(timeout, proxyServerInfo) : RestUtils.createHttpClient(timeout);
	}

	public void shutdown() {
		if (httpClient != null) try { httpClient.close(); } catch (Exception e) {}
	}

	public String post(Payload payload) {
		if (payload != null) {
			String message = null;
			try {
				message = mapper.writeValueAsString(payload);
			} catch (JsonProcessingException e) {
				throw new SlackException(e);
			}

			Map<String, String> parameters = new HashMap<String, String>();
			parameters.put("payload", message);
			return RestUtils.execute(httpClient, this.webhookUrl, RestUtils.createUrlEncodedFormEntity(parameters));
		}
		return null;
	}

}
