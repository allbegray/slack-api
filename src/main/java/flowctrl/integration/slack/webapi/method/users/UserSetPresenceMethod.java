package flowctrl.integration.slack.webapi.method.users;

import java.util.List;
import java.util.Map;

import flowctrl.integration.slack.validation.Problem;
import flowctrl.integration.slack.validation.ValidationError;
import flowctrl.integration.slack.webapi.SlackWebApiConstants;
import flowctrl.integration.slack.webapi.method.AbstractMethod;

public class UserSetPresenceMethod extends AbstractMethod {

	public UserSetPresenceMethod(String presence) {
		this.presence = presence;
	}

	protected String presence;

	public String getPresence() {
		return presence;
	}

	public void setPresence(String presence) {
		this.presence = presence;
	}

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.USERS_SET_PRESENCE;
	}

	@Override
	public void validate(List<ValidationError> errors) {
		if (presence == null) {
			addError(errors, "presence", Problem.REQUIRED, null);
		} else if (!("auto".equals(presence) || "away".equals(presence))) {
			addError(errors, "presence", Problem.PATTERN_NOT_MATCH, "\"presence\" must be either \"auto\" or \"away\".");
		}
	}

	@Override
	protected void createParameters(Map<String, String> parameters) {
		parameters.put("presence", presence);
	}

}
