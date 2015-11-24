package flowctrl.integration.slack.webhook;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.impl.client.CloseableHttpClient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import flowctrl.integration.slack.RestUtils;
import flowctrl.integration.slack.exception.SlackArgumentException;
import flowctrl.integration.slack.exception.SlackException;
import flowctrl.integration.slack.type.Payload;
import flowctrl.integration.slack.webapi.SlackWebApiConstants;

public class SlackWebhookClient {

	private String webhookUrl;
	private ObjectMapper mapper;
	private CloseableHttpClient httpClient;

	public SlackWebhookClient(String webhookUrl) {
		this(webhookUrl, null);
	}

	public SlackWebhookClient(String webhookUrl, ObjectMapper mapper) {
		this(webhookUrl, mapper, SlackWebApiConstants.DEFAULT_TIMEOUT);
	}

	public SlackWebhookClient(String webhookUrl, ObjectMapper mapper, int timeout) {
		if (webhookUrl == null) {
			throw new SlackArgumentException("Missing WebHook URL Configuration @ SlackApi");

		} else if (!webhookUrl.startsWith("https://hooks.slack.com/services/")) {
			throw new SlackArgumentException("Invalid Service URL. WebHook URL Format: https://hooks.slack.com/services/{id_1}/{id_2}/{token}");
		}

		this.webhookUrl = webhookUrl;
		this.mapper = mapper != null ? mapper : new ObjectMapper();
		httpClient = RestUtils.createHttpClient(timeout);
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
