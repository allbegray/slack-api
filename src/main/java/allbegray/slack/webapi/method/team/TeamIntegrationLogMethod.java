package allbegray.slack.webapi.method.team;

import java.util.Map;

import allbegray.slack.webapi.SlackWebApiConstants;
import allbegray.slack.webapi.method.AbstractPagingMethod;

public class TeamIntegrationLogMethod extends AbstractPagingMethod {

	protected String service_id;
	protected String app_id;
	protected String user;
	protected String change_type;

	public String getService_id() {
		return service_id;
	}

	public void setService_id(String service_id) {
		this.service_id = service_id;
	}

	public String getApp_id() {
		return app_id;
	}

	public void setApp_id(String app_id) {
		this.app_id = app_id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getChange_type() {
		return change_type;
	}

	public void setChange_type(String change_type) {
		this.change_type = change_type;
	}

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.TEAM_INTEGRATION_LOGS;
	}

	@Override
	protected void createParameters(Map<String, String> parameters) {
		super.createParameters(parameters);
		if (service_id != null) {
			parameters.put("service_id", service_id);
		}
		if (app_id != null) {
			parameters.put("app_id", app_id);
		}
		if (user != null) {
			parameters.put("user", user);
		}
		if (change_type != null) {
			parameters.put("change_type", change_type);
		}
	}

}
