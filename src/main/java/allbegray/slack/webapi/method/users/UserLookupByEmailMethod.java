package allbegray.slack.webapi.method.users;

import allbegray.slack.validation.Problem;
import allbegray.slack.validation.ValidationError;
import allbegray.slack.webapi.SlackWebApiConstants;
import allbegray.slack.webapi.method.AbstractMethod;

import java.util.List;
import java.util.Map;

public class UserLookupByEmailMethod extends AbstractMethod {

	public UserLookupByEmailMethod(String email) {
		this.email = email;
	}

	protected String email;

	public String getUser() {
		return email;
	}

	public void setUser(String user) {
		this.email = user;
	}

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.USERS_LOOKUP_BY_EMAIL;
	}

	@Override
	public void validate(List<ValidationError> errors) {
		if (email == null) {
			addError(errors, "email", Problem.REQUIRED);
		}
	}

	@Override
	protected void createParameters(Map<String, String> parameters) {
		parameters.put("email", email);
	}

}
