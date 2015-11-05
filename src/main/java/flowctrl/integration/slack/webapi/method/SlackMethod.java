package flowctrl.integration.slack.webapi.method;

import java.util.List;
import java.util.Map;

import flowctrl.integration.slack.validation.ValidationError;

public interface SlackMethod {

	boolean isRequiredToken();

	String getMethodName();

	void validate(List<ValidationError> errors);

	Map<String, String> getParameters();

}
