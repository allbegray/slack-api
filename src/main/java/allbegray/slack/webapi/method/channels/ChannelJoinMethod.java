package allbegray.slack.webapi.method.channels;

import java.util.List;
import java.util.Map;

import allbegray.slack.validation.Problem;
import allbegray.slack.validation.ValidationError;
import allbegray.slack.webapi.SlackWebApiConstants;
import allbegray.slack.webapi.method.AbstractMethod;

public class ChannelJoinMethod extends AbstractMethod {

	public ChannelJoinMethod(String name) {
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
		return SlackWebApiConstants.CHANNELS_JOIN;
	}

	@Override
	public void validate(List<ValidationError> errors) {
		if (name == null) {
			addError(errors, "name", Problem.REQUIRED);
		}
	}

	@Override
	protected void createParameters(Map<String, String> parameters) {
		parameters.put("name", name);
	}

}
