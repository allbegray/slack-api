package allbegray.slack.webapi.method.groups;

import allbegray.slack.webapi.method.channels.ChannelInviteMethod;
import allbegray.slack.webapi.SlackWebApiConstants;

public class GroupInviteMethod extends ChannelInviteMethod {

	public GroupInviteMethod(String channel, String user) {
		super(channel, user);
	}

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.GROUPS_INVITE;
	}

}
