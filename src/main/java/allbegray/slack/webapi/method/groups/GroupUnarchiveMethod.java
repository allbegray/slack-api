package allbegray.slack.webapi.method.groups;

import allbegray.slack.webapi.SlackWebApiConstants;
import allbegray.slack.webapi.method.channels.ChannelUnarchiveMethod;

public class GroupUnarchiveMethod extends ChannelUnarchiveMethod {

	public GroupUnarchiveMethod(String channel) {
		super(channel);
	}

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.GROUPS_UNARCHIVE;
	}

}
