package flowctrl.integration.slack.webapi.method.mpim;

import java.util.List;
import java.util.Map;

import flowctrl.integration.slack.validation.Problem;
import flowctrl.integration.slack.validation.ValidationError;
import flowctrl.integration.slack.webapi.SlackWebApiConstants;
import flowctrl.integration.slack.webapi.method.AbstractMethod;

public class MpimOpenMethod extends AbstractMethod {

	public MpimOpenMethod(List<String> users) {
		this.users = users;
	}

	protected List<String> users;

	public List<String> getUsers() {
		return users;
	}

	public void setUsers(List<String> users) {
		this.users = users;
	}

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.MPIM_OPEN;
	}

	@Override
	public void validate(List<ValidationError> errors) {
		if (users == null || users.isEmpty()) {
			addError(errors, "users", Problem.REQUIRED);
		}
	}

	@Override
	protected void createParameters(Map<String, String> parameters) {
		StringBuffer sb = new StringBuffer("");
		for (String s : users) {
			if (s == null) {
				continue;
			}

			if (sb.length() > 0) {
				sb.append(",");
			}
			sb.append(s);
		}
		parameters.put("users", sb.toString());
	}

}
