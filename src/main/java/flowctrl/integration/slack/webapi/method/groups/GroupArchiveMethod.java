package flowctrl.integration.slack.webapi.method.groups;

import flowctrl.integration.slack.webapi.SlackWebApiConstants;
import flowctrl.integration.slack.webapi.method.channels.ChannelArchiveMethod;

public class GroupArchiveMethod extends ChannelArchiveMethod {

	public GroupArchiveMethod(String channel) {
		super(channel);
	}

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.GROUPS_ARCHIVE;
	}

}
