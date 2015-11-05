package flowctrl.integration.slack.webapi.method.groups;

import flowctrl.integration.slack.webapi.SlackWebApiConstants;
import flowctrl.integration.slack.webapi.method.channels.ChannelInviteMethod;

public class GroupInviteMethod extends ChannelInviteMethod {

	public GroupInviteMethod(String channel, String user) {
		super(channel, user);
	}

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.GROUPS_INVITE;
	}

}
