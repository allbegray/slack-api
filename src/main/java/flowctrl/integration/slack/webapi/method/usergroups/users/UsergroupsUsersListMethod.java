package flowctrl.integration.slack.webapi.method.usergroups.users;

import java.util.List;
import java.util.Map;

import flowctrl.integration.slack.validation.Problem;
import flowctrl.integration.slack.validation.ValidationError;
import flowctrl.integration.slack.webapi.SlackWebApiConstants;
import flowctrl.integration.slack.webapi.method.AbstractMethod;

public class UsergroupsUsersListMethod extends AbstractMethod {

	public UsergroupsUsersListMethod(String usergroup) {
		this.usergroup = usergroup;
	}

	protected String usergroup;
	protected boolean include_disabled;

	public String getUsergroup() {
		return usergroup;
	}

	public void setUsergroup(String usergroup) {
		this.usergroup = usergroup;
	}

	public boolean isInclude_disabled() {
		return include_disabled;
	}

	public void setInclude_disabled(boolean include_disabled) {
		this.include_disabled = include_disabled;
	}

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.USERGROUPS_USERS_LIST;
	}

	@Override
	public void validate(List<ValidationError> errors) {
		if (usergroup == null) {
			addError(errors, "usergroup", Problem.REQUIRED);
		}
	}

	@Override
	protected void createParameters(Map<String, String> parameters) {
		parameters.put("usergroup", usergroup);
		if (include_disabled) {
			parameters.put("include_disabled", "1");
		}
	}

}
