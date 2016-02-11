package flowctrl.integration.slack.webapi.method.dnd;

import java.util.List;
import java.util.Map;

import flowctrl.integration.slack.validation.ValidationError;
import flowctrl.integration.slack.webapi.SlackWebApiConstants;
import flowctrl.integration.slack.webapi.method.AbstractMethod;

public class EndDndMethod extends AbstractMethod {

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.DND_END_DND;
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
