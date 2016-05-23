package allbegray.slack.webapi.method.dnd;

import java.util.List;
import java.util.Map;

import allbegray.slack.validation.ValidationError;
import allbegray.slack.webapi.SlackWebApiConstants;
import allbegray.slack.webapi.method.AbstractMethod;

public class EndSnoozeMethod extends AbstractMethod {

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.DND_END_SNOOZE;
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
