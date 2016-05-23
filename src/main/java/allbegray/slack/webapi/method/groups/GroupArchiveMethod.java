package allbegray.slack.webapi.method.groups;

import allbegray.slack.webapi.SlackWebApiConstants;
import allbegray.slack.webapi.method.channels.ChannelArchiveMethod;

public class GroupArchiveMethod extends ChannelArchiveMethod {

	public GroupArchiveMethod(String channel) {
		super(channel);
	}

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.GROUPS_ARCHIVE;
	}

}
