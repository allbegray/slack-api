package allbegray.slack.webapi.method.usergroups;

import java.util.List;
import java.util.Map;

import allbegray.slack.validation.ValidationError;
import allbegray.slack.webapi.SlackWebApiConstants;
import allbegray.slack.webapi.method.AbstractMethod;

public class UsergroupsListMethod extends AbstractMethod {

	protected boolean include_disabled;
	protected boolean include_count;
	protected boolean include_users;

	public boolean isInclude_disabled() {
		return include_disabled;
	}

	public void setInclude_disabled(boolean include_disabled) {
		this.include_disabled = include_disabled;
	}

	public boolean isInclude_count() {
		return include_count;
	}

	public void setInclude_count(boolean include_count) {
		this.include_count = include_count;
	}

	public boolean isInclude_users() {
		return include_users;
	}

	public void setInclude_users(boolean include_users) {
		this.include_users = include_users;
	}

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.USERGROUPS_LIST;
	}

	@Override
	public void validate(List<ValidationError> errors) {
		// ignore
	}

	@Override
	protected void createParameters(Map<String, String> parameters) {
		if (include_disabled) {
			parameters.put("include_disabled", "1");
		}
		if (include_count) {
			parameters.put("include_count", "1");
		}
		if (include_users) {
			parameters.put("include_users", "1");
		}
	}

}
