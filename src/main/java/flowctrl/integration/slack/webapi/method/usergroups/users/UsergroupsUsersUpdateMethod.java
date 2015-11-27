package flowctrl.integration.slack.webapi.method.usergroups.users;

import java.util.List;
import java.util.Map;

import flowctrl.integration.slack.validation.Problem;
import flowctrl.integration.slack.validation.ValidationError;
import flowctrl.integration.slack.webapi.SlackWebApiConstants;
import flowctrl.integration.slack.webapi.method.AbstractMethod;

public class UsergroupsUsersUpdateMethod extends AbstractMethod {

	public UsergroupsUsersUpdateMethod(String usergroup, List<String> users) {
		this.usergroup = usergroup;
		this.users = users;
	}

	protected String usergroup;
	protected List<String> users;
	protected boolean include_count;

	public String getUsergroup() {
		return usergroup;
	}

	public void setUsergroup(String usergroup) {
		this.usergroup = usergroup;
	}

	public List<String> getUsers() {
		return users;
	}

	public void setUsers(List<String> users) {
		this.users = users;
	}

	public boolean isInclude_count() {
		return include_count;
	}

	public void setInclude_count(boolean include_count) {
		this.include_count = include_count;
	}

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.USERGROUPS_USERS_UPDATE;
	}

	@Override
	public void validate(List<ValidationError> errors) {
		if (usergroup == null) {
			addError(errors, "usergroup", Problem.REQUIRED);
		}
		if (users == null || users.isEmpty()) {
			addError(errors, "users", Problem.REQUIRED);
		}
	}

	@Override
	protected void createParameters(Map<String, String> parameters) {
		parameters.put("usergroup", usergroup);

		StringBuffer sb = new StringBuffer();
		for (String u : users) {
			if (sb.length() > 0)
				sb.append(",");
			sb.append(u);
		}
		parameters.put("users", sb.toString());

		if (include_count) {
			parameters.put("include_count", "1");
		}
	}

}
