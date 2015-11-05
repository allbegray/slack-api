package flowctrl.integration.slack.webapi.method.im;

import java.util.List;
import java.util.Map;

import flowctrl.integration.slack.validation.ValidationError;
import flowctrl.integration.slack.webapi.SlackWebApiConstants;
import flowctrl.integration.slack.webapi.method.AbstractMethod;

public class ImListMethod extends AbstractMethod {

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.IM_LIST;
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
