package allbegray.slack.webapi.method;

import java.util.List;
import java.util.Map;

import allbegray.slack.validation.ValidationError;

public interface SlackMethod {

	boolean isRequiredToken();

	boolean isRequiredUserToken();

	String getMethodName();

	void validate(List<ValidationError> errors);

	Map<String, String> getParameters();

}
