package flowctrl.integration.slack.webapi.method.groups;

import flowctrl.integration.slack.webapi.SlackWebApiConstants;
import flowctrl.integration.slack.webapi.method.channels.ChannelListMethod;

public class GroupListMethod extends ChannelListMethod {

	public GroupListMethod(boolean exclude_archived) {
		super(exclude_archived);
	}

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.GROUPS_LIST;
	}

}
