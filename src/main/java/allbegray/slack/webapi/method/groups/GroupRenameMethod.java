package allbegray.slack.webapi.method.groups;

import allbegray.slack.webapi.method.channels.ChannelRenameMethod;
import allbegray.slack.webapi.SlackWebApiConstants;

public class GroupRenameMethod extends ChannelRenameMethod {

	public GroupRenameMethod(String channel, String name) {
		super(channel, name);
	}

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.GROUPS_RENAME;
	}

}
