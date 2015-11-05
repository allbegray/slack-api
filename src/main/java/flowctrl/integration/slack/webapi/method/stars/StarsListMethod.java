package flowctrl.integration.slack.webapi.method.stars;

import java.util.Map;

import flowctrl.integration.slack.webapi.SlackWebApiConstants;
import flowctrl.integration.slack.webapi.method.AbstractPagingMethod;

public class StarsListMethod extends AbstractPagingMethod {

	protected String user;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.STARS_LIST;
	}

	@Override
	protected void createParameters(Map<String, String> parameters) {
		super.createParameters(parameters);
		if (user != null) {
			parameters.put("user", user);
		}
	}

}
