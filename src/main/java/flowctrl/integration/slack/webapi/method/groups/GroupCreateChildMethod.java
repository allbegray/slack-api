package flowctrl.integration.slack.webapi.method.groups;

import flowctrl.integration.slack.webapi.SlackWebApiConstants;

public class GroupCreateChildMethod extends GroupCreateMethod {

	public GroupCreateChildMethod(String channel) {
		super(channel);
	}

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.GROUPS_CREATE_CHILD;
	}

}
