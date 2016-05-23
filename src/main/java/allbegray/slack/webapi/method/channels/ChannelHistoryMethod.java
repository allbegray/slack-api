package allbegray.slack.webapi.method.channels;

import allbegray.slack.webapi.SlackWebApiConstants;
import allbegray.slack.webapi.method.AbstractHistoryMethod;

public class ChannelHistoryMethod extends AbstractHistoryMethod {

	public ChannelHistoryMethod(String channel) {
		super(channel);
	}

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.CHANNELS_HISTORY;
	}

}
