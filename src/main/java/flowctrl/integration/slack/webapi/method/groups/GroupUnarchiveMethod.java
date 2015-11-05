package flowctrl.integration.slack.webapi.method.groups;

import flowctrl.integration.slack.webapi.SlackWebApiConstants;
import flowctrl.integration.slack.webapi.method.channels.ChannelUnarchiveMethod;

public class GroupUnarchiveMethod extends ChannelUnarchiveMethod {

	public GroupUnarchiveMethod(String channel) {
		super(channel);
	}

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.GROUPS_UNARCHIVE;
	}

}
