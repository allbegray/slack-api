package allbegray.slack.webapi.method.reactions;

import java.util.List;
import java.util.Map;

import allbegray.slack.validation.Problem;
import allbegray.slack.validation.ValidationError;
import allbegray.slack.webapi.SlackWebApiConstants;
import allbegray.slack.webapi.method.AbstractItemMethod;

public class ReactionsAddMethod extends AbstractItemMethod {

	public ReactionsAddMethod(String name) {
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
		return SlackWebApiConstants.REACTIONS_ADD;
	}

	@Override
	public void validate(List<ValidationError> errors) {
		super.validate(errors);
		if (name == null) {
			addError(errors, "name", Problem.REQUIRED);
		}
	}

	@Override
	protected void createParameters(Map<String, String> parameters) {
		super.createParameters(parameters);
		parameters.put("name", name);
	}

}
