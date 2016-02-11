package flowctrl.integration.slack.webapi.method.dnd;

import java.util.List;
import java.util.Map;

import flowctrl.integration.slack.validation.ValidationError;
import flowctrl.integration.slack.webapi.SlackWebApiConstants;
import flowctrl.integration.slack.webapi.method.AbstractMethod;

public class DndTeamInfoMethod extends AbstractMethod {

	private List<String> users;

	public DndTeamInfoMethod() {
	}

	public DndTeamInfoMethod(List<String> users) {
		this.users = users;
	}

	public List<String> getUsers() {
		return users;
	}

	public void setUsers(List<String> users) {
		this.users = users;
	}

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.DND_TEAM_INFO;
	}

	@Override
	public void validate(List<ValidationError> errors) {
		// ignore
	}

	@Override
	protected void createParameters(Map<String, String> parameters) {
		if (users != null && !users.isEmpty()) {
			StringBuffer sb = new StringBuffer();
			for (String u : users) {
				if (sb.length() > 0)
					sb.append(",");
				sb.append(u);
			}
			parameters.put("users", sb.toString());
		}
	}

}
