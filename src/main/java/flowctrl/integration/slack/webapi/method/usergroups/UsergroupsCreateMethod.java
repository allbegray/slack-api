package flowctrl.integration.slack.webapi.method.usergroups;

import java.util.List;
import java.util.Map;

import flowctrl.integration.slack.validation.Problem;
import flowctrl.integration.slack.validation.ValidationError;
import flowctrl.integration.slack.webapi.SlackWebApiConstants;
import flowctrl.integration.slack.webapi.method.AbstractMethod;

public class UsergroupsCreateMethod extends AbstractMethod {

	public UsergroupsCreateMethod(String name) {
		this.name = name;
	}

	protected String name;
	protected String handle;
	protected String description;
	protected List<String> channels;
	protected boolean include_count;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHandle() {
		return handle;
	}

	public void setHandle(String handle) {
		this.handle = handle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getChannels() {
		return channels;
	}

	public void setChannels(List<String> channels) {
		this.channels = channels;
	}

	public boolean isInclude_count() {
		return include_count;
	}

	public void setInclude_count(boolean include_count) {
		this.include_count = include_count;
	}

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.USERGROUPS_CREATE;
	}

	@Override
	public void validate(List<ValidationError> errors) {
		if (name == null) {
			addError(errors, "name", Problem.REQUIRED, null);
		}
	}

	@Override
	protected void createParameters(Map<String, String> parameters) {
		parameters.put("name", name);
		if (handle != null) {
			parameters.put("handle", handle);
		}
		if (description != null) {
			parameters.put("description", description);
		}
		if (channels != null && !channels.isEmpty()) {
			StringBuffer sb = new StringBuffer();
			for (String ch : channels) {
				if (sb.length() > 0)
					sb.append(",");
				sb.append(ch);
			}
			parameters.put("channels", sb.toString());
		}
		if (include_count) {
			parameters.put("include_count", "1");
		}
	}

}
