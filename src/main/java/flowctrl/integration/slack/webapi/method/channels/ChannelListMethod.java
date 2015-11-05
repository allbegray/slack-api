package flowctrl.integration.slack.webapi.method.channels;

import java.util.List;
import java.util.Map;

import flowctrl.integration.slack.validation.ValidationError;
import flowctrl.integration.slack.webapi.SlackWebApiConstants;
import flowctrl.integration.slack.webapi.method.AbstractMethod;

public class ChannelListMethod extends AbstractMethod {

	public ChannelListMethod() {
	}

	public ChannelListMethod(boolean exclude_archived) {
		this.exclude_archived = exclude_archived;
	}

	protected boolean exclude_archived;

	public boolean isExclude_archived() {
		return exclude_archived;
	}

	public void setExclude_archived(boolean exclude_archived) {
		this.exclude_archived = exclude_archived;
	}

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.CHANNELS_LIST;
	}

	@Override
	public void validate(List<ValidationError> errors) {
		// ignore
	}

	@Override
	protected void createParameters(Map<String, String> parameters) {
		parameters.put("exclude_archived", exclude_archived ? "1" : "0");
	}

}
