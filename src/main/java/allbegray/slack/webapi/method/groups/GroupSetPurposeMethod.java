package allbegray.slack.webapi.method.groups;

import allbegray.slack.webapi.method.channels.ChannelSetPurposeMethod;
import allbegray.slack.webapi.SlackWebApiConstants;

public class GroupSetPurposeMethod extends ChannelSetPurposeMethod {

	public GroupSetPurposeMethod(String channel, String purpose) {
		super(channel, purpose);
	}

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.GROUPS_SET_PURPOSE;
	}

}
