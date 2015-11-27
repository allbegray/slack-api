package flowctrl.integration.slack.webapi.method.usergroups;

import flowctrl.integration.slack.webapi.SlackWebApiConstants;

public class UsergroupsUpdateMethod extends UsergroupsCreateMethod {

	public UsergroupsUpdateMethod(String name) {
		super(name);
	}

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.USERGROUPS_UPDATE;
	}

}
