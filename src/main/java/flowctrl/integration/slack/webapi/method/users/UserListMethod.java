package flowctrl.integration.slack.webapi.method.users;

import java.util.List;
import java.util.Map;

import flowctrl.integration.slack.validation.ValidationError;
import flowctrl.integration.slack.webapi.SlackWebApiConstants;
import flowctrl.integration.slack.webapi.method.AbstractMethod;

public class UserListMethod extends AbstractMethod {

	public UserListMethod() {
	}

	public UserListMethod(String presence) {
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
		return SlackWebApiConstants.USERS_LIST;
	}

	@Override
	public void validate(List<ValidationError> errors) {
		// ignore
	}

	@Override
	protected void createParameters(Map<String, String> parameters) {
		if (presence != null) {
			parameters.put("presence", presence);
		}
	}

}
