package allbegray.slack.webapi.method.groups;

import java.util.List;
import java.util.Map;

import allbegray.slack.validation.Problem;
import allbegray.slack.validation.SlackFieldValidationUtils;
import allbegray.slack.validation.ValidationError;
import allbegray.slack.webapi.SlackWebApiConstants;
import allbegray.slack.webapi.method.AbstractMethod;

public class GroupCreateMethod extends AbstractMethod {

	public GroupCreateMethod(String name) {
		this.name = name;
	}

	protected String name;

	public String getName() {
		return name;
	}

	public void setName(String channel) {
		this.name = channel;
	}

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.GROUPS_CREATE;
	}

	@Override
	public void validate(List<ValidationError> errors) {
		if (name == null) {
			errors.add(new ValidationError("name", Problem.REQUIRED, null));
		} else if (!SlackFieldValidationUtils.validChannelName(name)) {
			errors.add(new ValidationError("name", Problem.PATTERN_NOT_MATCH, SlackFieldValidationUtils.ERROR_MSG));
		}
	}

	@Override
	protected void createParameters(Map<String, String> parameters) {
		parameters.put("name", name);
	}

}
