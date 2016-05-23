package allbegray.slack.webapi.method.im;

import java.util.List;
import java.util.Map;

import allbegray.slack.validation.Problem;
import allbegray.slack.validation.ValidationError;
import allbegray.slack.webapi.SlackWebApiConstants;
import allbegray.slack.webapi.method.AbstractMethod;

public class ImOpenMethod extends AbstractMethod {

	public ImOpenMethod(String user) {
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
		return SlackWebApiConstants.IM_OPEN;
	}

	@Override
	public void validate(List<ValidationError> errors) {
		if (user == null) {
			addError(errors, "user", Problem.REQUIRED);
		}
	}

	@Override
	protected void createParameters(Map<String, String> parameters) {
		parameters.put("user", user);
	}

}
