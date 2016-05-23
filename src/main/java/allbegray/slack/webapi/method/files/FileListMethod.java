package allbegray.slack.webapi.method.files;

import java.util.Map;

import allbegray.slack.webapi.method.AbstractPagingMethod;
import allbegray.slack.webapi.SlackWebApiConstants;

public class FileListMethod extends AbstractPagingMethod {

	protected String user;
	protected String ts_from;
	protected String ts_to;
	protected String types;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getTs_from() {
		return ts_from;
	}

	public void setTs_from(String ts_from) {
		this.ts_from = ts_from;
	}

	public String getTs_to() {
		return ts_to;
	}

	public void setTs_to(String ts_to) {
		this.ts_to = ts_to;
	}

	public String getTypes() {
		return types;
	}

	public void setTypes(String types) {
		this.types = types;
	}

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.FILES_LIST;
	}

	@Override
	protected void createParameters(Map<String, String> parameters) {
		super.createParameters(parameters);
		if (user != null) {
			parameters.put("user", user);
		}
		parameters.put("ts_from", ts_from != null ? ts_from : "0");
		parameters.put("ts_to", ts_to != null ? ts_to : "now");
		parameters.put("types", types != null ? types : "all");
	}

}
