package allbegray.slack.webapi.method.groups;

import allbegray.slack.webapi.SlackWebApiConstants;

public class GroupCreateChildMethod extends GroupCreateMethod {

	public GroupCreateChildMethod(String name) {
		super(name);
	}

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.GROUPS_CREATE_CHILD;
	}

}
