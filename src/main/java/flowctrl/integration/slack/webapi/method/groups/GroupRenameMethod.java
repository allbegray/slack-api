package flowctrl.integration.slack.webapi.method.groups;

import flowctrl.integration.slack.webapi.SlackWebApiConstants;
import flowctrl.integration.slack.webapi.method.channels.ChannelRenameMethod;

public class GroupRenameMethod extends ChannelRenameMethod {

	public GroupRenameMethod(String channel, String name) {
		super(channel, name);
	}

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.GROUPS_RENAME;
	}

}
