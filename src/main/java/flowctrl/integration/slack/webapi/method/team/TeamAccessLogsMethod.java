package flowctrl.integration.slack.webapi.method.team;

import flowctrl.integration.slack.webapi.SlackWebApiConstants;
import flowctrl.integration.slack.webapi.method.AbstractPagingMethod;

public class TeamAccessLogsMethod extends AbstractPagingMethod {

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.TEAM_ACCESSLOGS;
	}

}
