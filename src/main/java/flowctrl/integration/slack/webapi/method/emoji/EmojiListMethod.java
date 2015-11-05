package flowctrl.integration.slack.webapi.method.emoji;

import java.util.List;
import java.util.Map;

import flowctrl.integration.slack.validation.ValidationError;
import flowctrl.integration.slack.webapi.SlackWebApiConstants;
import flowctrl.integration.slack.webapi.method.AbstractMethod;

public class EmojiListMethod extends AbstractMethod {

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.EMOJI_LIST;
	}

	@Override
	public void validate(List<ValidationError> errors) {
		// ignore
	}

	@Override
	protected void createParameters(Map<String, String> parameters) {
		// ignore
	}

}
