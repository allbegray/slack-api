package flowctrl.integration.slack.webapi.method.groups;

import flowctrl.integration.slack.webapi.SlackWebApiConstants;
import flowctrl.integration.slack.webapi.method.channels.ChannelMarkMethod;

public class GroupMarkMethod extends ChannelMarkMethod {

	public GroupMarkMethod(String channel, String ts) {
		super(channel, ts);
	}

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.GROUPS_MARK;
	}

}
