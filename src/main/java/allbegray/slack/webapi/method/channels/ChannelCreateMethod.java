package allbegray.slack.webapi.method.channels;

import java.util.List;
import java.util.Map;

import allbegray.slack.validation.Problem;
import allbegray.slack.validation.SlackFieldValidationUtils;
import allbegray.slack.validation.ValidationError;
import allbegray.slack.webapi.SlackWebApiConstants;
import allbegray.slack.webapi.method.AbstractMethod;

public class ChannelCreateMethod extends AbstractMethod {

	public ChannelCreateMethod(String name) {
		this.name = name;
	}

	protected String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.CHANNELS_CREATE;
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
