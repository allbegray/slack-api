package allbegray.slack.webapi.method.users;

import java.util.List;
import java.util.Map;

import allbegray.slack.validation.Problem;
import allbegray.slack.validation.ValidationError;
import allbegray.slack.webapi.SlackWebApiConstants;
import allbegray.slack.webapi.method.AbstractMethod;

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
			addError(errors, "presence", Problem.REQUIRED);
		} else if (!("auto".equalsIgnoreCase(presence) || "away".equalsIgnoreCase(presence))) {
			addError(errors, "presence", Problem.PATTERN_NOT_MATCH, "\"presence\" must be either \"auto\" or \"away\".");
		}
	}

	@Override
	protected void createParameters(Map<String, String> parameters) {
		parameters.put("presence", presence.toLowerCase());
	}

}
