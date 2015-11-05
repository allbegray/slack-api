package flowctrl.integration.slack.webapi.method.groups;

import flowctrl.integration.slack.webapi.SlackWebApiConstants;
import flowctrl.integration.slack.webapi.method.channels.ChannelInfoMethod;

public class GroupInfoMethod extends ChannelInfoMethod {

	public GroupInfoMethod(String channel) {
		super(channel);
	}

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.GROUPS_INFO;
	}

}
