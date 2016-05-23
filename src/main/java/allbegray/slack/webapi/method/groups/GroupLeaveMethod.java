package allbegray.slack.webapi.method.groups;

import allbegray.slack.webapi.SlackWebApiConstants;
import allbegray.slack.webapi.method.channels.ChannelLeaveMethod;

public class GroupLeaveMethod extends ChannelLeaveMethod {

	public GroupLeaveMethod(String channel) {
		super(channel);
	}

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.GROUPS_LEAVE;
	}

}
