package flowctrl.integration.slack.webapi.method.groups;

import java.util.List;
import java.util.Map;

import flowctrl.integration.slack.validation.ChannelNameValidator;
import flowctrl.integration.slack.validation.Problem;
import flowctrl.integration.slack.validation.ValidationError;
import flowctrl.integration.slack.webapi.SlackWebApiConstants;
import flowctrl.integration.slack.webapi.method.AbstractMethod;

public class GroupCreateMethod extends AbstractMethod {

	public GroupCreateMethod(String channel) {
		this.channel = channel;
	}

	protected String channel;

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.GROUPS_CREATE;
	}

	@Override
	public void validate(List<ValidationError> errors) {
		if (channel == null) {
			errors.add(new ValidationError("channel", Problem.REQUIRED, null));
		} else if (!ChannelNameValidator.valid(channel)) {
			errors.add(new ValidationError("channel", Problem.PATTERN_NOT_MATCH, ChannelNameValidator.ERROR_MSG));
		}
	}

	@Override
	protected void createParameters(Map<String, String> parameters) {
		parameters.put("channel", channel);
	}

}
