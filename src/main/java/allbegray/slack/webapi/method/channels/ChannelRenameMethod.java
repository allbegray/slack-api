package allbegray.slack.webapi.method.channels;

import java.util.List;
import java.util.Map;

import allbegray.slack.validation.Problem;
import allbegray.slack.validation.ValidationError;
import allbegray.slack.webapi.SlackWebApiConstants;
import allbegray.slack.webapi.method.AbstractMethod;

public class ChannelRenameMethod extends AbstractMethod {

	public ChannelRenameMethod(String channel, String name) {
		this.channel = channel;
		this.name = name;
	}

	protected String channel;
	protected String name;

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.CHANNELS_RENAME;
	}

	@Override
	public void validate(List<ValidationError> errors) {
		if (channel == null) {
			addError(errors, "channel", Problem.REQUIRED);
		}
		if (name == null) {
			addError(errors, "name", Problem.REQUIRED);
		}
	}

	@Override
	protected void createParameters(Map<String, String> parameters) {
		parameters.put("channel", channel);
		parameters.put("name", name);
	}

}
