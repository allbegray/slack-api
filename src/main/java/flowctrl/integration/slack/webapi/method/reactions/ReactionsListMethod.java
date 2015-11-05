package flowctrl.integration.slack.webapi.method.reactions;

import java.util.Map;

import flowctrl.integration.slack.webapi.SlackWebApiConstants;
import flowctrl.integration.slack.webapi.method.AbstractPagingMethod;

public class ReactionsListMethod extends AbstractPagingMethod {

	protected String user;
	protected boolean full;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public boolean isFull() {
		return full;
	}

	public void setFull(boolean full) {
		this.full = full;
	}

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.REACTIONS_LIST;
	}

	@Override
	protected void createParameters(Map<String, String> parameters) {
		super.createParameters(parameters);
		if (user != null) {
			parameters.put("user", user);
		}
		if (full) {
			parameters.put("full", String.valueOf(full));
		}
	}

}
