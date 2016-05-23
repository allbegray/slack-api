package allbegray.slack.webapi.method.groups;

import allbegray.slack.webapi.SlackWebApiConstants;
import allbegray.slack.webapi.method.channels.ChannelInfoMethod;

public class GroupInfoMethod extends ChannelInfoMethod {

	public GroupInfoMethod(String channel) {
		super(channel);
	}

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.GROUPS_INFO;
	}

}
