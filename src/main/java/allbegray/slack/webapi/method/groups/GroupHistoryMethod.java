package allbegray.slack.webapi.method.groups;

import allbegray.slack.webapi.SlackWebApiConstants;
import allbegray.slack.webapi.method.AbstractHistoryMethod;

public class GroupHistoryMethod extends AbstractHistoryMethod {

	public GroupHistoryMethod(String channel) {
		super(channel);
	}

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.GROUPS_HISTORY;
	}

}
