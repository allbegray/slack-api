package flowctrl.integration.slack.webapi.method.usergroups;

import java.util.List;
import java.util.Map;

import flowctrl.integration.slack.validation.Problem;
import flowctrl.integration.slack.validation.ValidationError;
import flowctrl.integration.slack.webapi.SlackWebApiConstants;
import flowctrl.integration.slack.webapi.method.AbstractMethod;

public class UsergroupsDisableMethod extends AbstractMethod {

	public UsergroupsDisableMethod(String usergroup) {
		this.usergroup = usergroup;
	}

	protected String usergroup;
	protected boolean include_count;

	public String getUsergroup() {
		return usergroup;
	}

	public void setUsergroup(String usergroup) {
		this.usergroup = usergroup;
	}

	public boolean isInclude_count() {
		return include_count;
	}

	public void setInclude_count(boolean include_count) {
		this.include_count = include_count;
	}

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.USERGROUPS_DISABLE;
	}

	@Override
	public void validate(List<ValidationError> errors) {
		if (usergroup == null) {
			addError(errors, "usergroup", Problem.REQUIRED, null);
		}
	}

	@Override
	protected void createParameters(Map<String, String> parameters) {
		parameters.put("usergroup", usergroup);
		if (include_count) {
			parameters.put("include_count", "1");
		}
	}

}
