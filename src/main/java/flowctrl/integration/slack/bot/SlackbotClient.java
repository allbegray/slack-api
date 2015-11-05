package flowctrl.integration.slack.bot;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.http.entity.StringEntity;

import flowctrl.integration.slack.RestUtils;
import flowctrl.integration.slack.exception.SlackArgumentException;
import flowctrl.integration.slack.webapi.SlackWebApiConstants;

public class SlackbotClient {

	private String slackbotUrl;
	private int timeout;

	public SlackbotClient(String slackbotUrl) {
		this(slackbotUrl, SlackWebApiConstants.DEFAULT_TIMEOUT);
	}

	public SlackbotClient(String slackbotUrl, int timeout) {
		this.timeout = timeout;
		if (slackbotUrl == null) {
			throw new SlackArgumentException("Missing Slackbot URL Configuration @ SlackApi");

		} else if (!slackbotUrl.contains(".slack.com/services/hooks/slackbot?token=")) {
			throw new SlackArgumentException("Invalid Service URL. Slackbot URL Format: https://{yourteam}.slack.com/services/hooks/slackbot?token={token}");
		}

		this.slackbotUrl = slackbotUrl;
	}

	public String post(String channel, String message) {
		String url = null;
		try {
			url = slackbotUrl + "&channel=" + URLEncoder.encode(channel, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
		return RestUtils.execute(url, new StringEntity(message, "UTF-8"), timeout);
	}

}
