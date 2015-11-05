package flowctrl.integration.slack.webapi.method.channels;

import flowctrl.integration.slack.webapi.SlackWebApiConstants;
import flowctrl.integration.slack.webapi.method.AbstractHistoryMethod;

public class ChannelHistoryMethod extends AbstractHistoryMethod {

	public ChannelHistoryMethod(String channel) {
		super(channel);
	}

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.CHANNELS_HISTORY;
	}

}
