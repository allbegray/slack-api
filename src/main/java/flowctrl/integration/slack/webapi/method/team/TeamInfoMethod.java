package flowctrl.integration.slack.webapi.method.team;

import java.util.List;
import java.util.Map;

import flowctrl.integration.slack.validation.ValidationError;
import flowctrl.integration.slack.webapi.SlackWebApiConstants;
import flowctrl.integration.slack.webapi.method.AbstractMethod;

public class TeamInfoMethod extends AbstractMethod {

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.TEAM_INFO;
	}

	@Override
	public void validate(List<ValidationError> errors) {
		// ignore
	}

	@Override
	protected void createParameters(Map<String, String> parameters) {
		// ignore
	}

}
