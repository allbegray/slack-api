package allbegray.slack.webapi.method.team;

import allbegray.slack.webapi.SlackWebApiConstants;
import allbegray.slack.webapi.method.AbstractPagingMethod;

public class TeamAccessLogsMethod extends AbstractPagingMethod {

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.TEAM_ACCESS_LOGS;
	}

}
