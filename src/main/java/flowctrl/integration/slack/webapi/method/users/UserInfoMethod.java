package flowctrl.integration.slack.webapi.method.users;

import java.util.List;
import java.util.Map;

import flowctrl.integration.slack.validation.Problem;
import flowctrl.integration.slack.validation.ValidationError;
import flowctrl.integration.slack.webapi.SlackWebApiConstants;
import flowctrl.integration.slack.webapi.method.AbstractMethod;

public class UserInfoMethod extends AbstractMethod {

	public UserInfoMethod(String user) {
		this.user = user;
	}

	protected String user;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.USERS_INFO;
	}

	@Override
	public void validate(List<ValidationError> errors) {
		if (user == null) {
			addError(errors, "user", Problem.REQUIRED, null);
		}
	}

	@Override
	protected void createParameters(Map<String, String> parameters) {
		parameters.put("user", user);
	}

}
