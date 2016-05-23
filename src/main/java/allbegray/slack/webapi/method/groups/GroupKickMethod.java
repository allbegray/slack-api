package allbegray.slack.webapi.method.groups;

import allbegray.slack.webapi.SlackWebApiConstants;
import allbegray.slack.webapi.method.channels.ChannelKickMethod;

public class GroupKickMethod extends ChannelKickMethod {

	public GroupKickMethod(String channel, String user) {
		super(channel, user);
	}

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.GROUPS_KICK;
	}

}
