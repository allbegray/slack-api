package flowctrl.integration.slack.webapi.method.reactions;

import java.util.List;
import java.util.Map;

import flowctrl.integration.slack.validation.Problem;
import flowctrl.integration.slack.validation.ValidationError;
import flowctrl.integration.slack.webapi.SlackWebApiConstants;
import flowctrl.integration.slack.webapi.method.AbstractItemMethod;

public class ReactionsGetMethod extends AbstractItemMethod {

	public ReactionsGetMethod(String name) {
		this.name = name;
	}

	protected String name;
	protected boolean full;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isFull() {
		return full;
	}

	public void setFull(boolean full) {
		this.full = full;
	}

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.REACTIONS_GET;
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
		if (full) {
			parameters.put("full", String.valueOf(full));
		}
	}

}
