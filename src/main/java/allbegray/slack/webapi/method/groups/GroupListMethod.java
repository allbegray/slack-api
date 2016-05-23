package allbegray.slack.webapi.method.groups;

import allbegray.slack.webapi.SlackWebApiConstants;
import allbegray.slack.webapi.method.channels.ChannelListMethod;

public class GroupListMethod extends ChannelListMethod {

	public GroupListMethod(boolean exclude_archived) {
		super(exclude_archived);
	}

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.GROUPS_LIST;
	}

}
