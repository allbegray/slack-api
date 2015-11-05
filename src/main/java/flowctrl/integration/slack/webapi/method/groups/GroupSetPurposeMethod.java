package flowctrl.integration.slack.webapi.method.groups;

import flowctrl.integration.slack.webapi.SlackWebApiConstants;
import flowctrl.integration.slack.webapi.method.channels.ChannelSetPurposeMethod;

public class GroupSetPurposeMethod extends ChannelSetPurposeMethod {

	public GroupSetPurposeMethod(String channel, String purpose) {
		super(channel, purpose);
	}

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.GROUPS_SET_PURPOSE;
	}

}
