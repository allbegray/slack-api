package flowctrl.integration.slack.webapi.method.groups;

import flowctrl.integration.slack.webapi.SlackWebApiConstants;
import flowctrl.integration.slack.webapi.method.channels.ChannelKickMethod;

public class GroupKickMethod extends ChannelKickMethod {

	public GroupKickMethod(String channel, String user) {
		super(channel, user);
	}

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.GROUPS_KICK;
	}

}
