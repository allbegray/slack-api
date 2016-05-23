package allbegray.slack.webapi.method.groups;

import allbegray.slack.webapi.method.channels.ChannelMarkMethod;
import allbegray.slack.webapi.SlackWebApiConstants;

public class GroupMarkMethod extends ChannelMarkMethod {

	public GroupMarkMethod(String channel, String ts) {
		super(channel, ts);
	}

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.GROUPS_MARK;
	}

}
