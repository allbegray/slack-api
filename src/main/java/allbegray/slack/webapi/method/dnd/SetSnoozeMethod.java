package allbegray.slack.webapi.method.dnd;

import java.util.List;
import java.util.Map;

import allbegray.slack.validation.Problem;
import allbegray.slack.validation.ValidationError;
import allbegray.slack.webapi.SlackWebApiConstants;
import allbegray.slack.webapi.method.AbstractMethod;

public class SetSnoozeMethod extends AbstractMethod {

	private String num_minutes;

	public SetSnoozeMethod(String num_minutes) {
		this.num_minutes = num_minutes;
	}

	public String getNum_minutes() {
		return num_minutes;
	}

	public void setNum_minutes(String num_minutes) {
		this.num_minutes = num_minutes;
	}

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.DND_SET_SNOOZE;
	}

	@Override
	public void validate(List<ValidationError> errors) {
		if (num_minutes == null) {
			addError(errors, "num_minutes", Problem.REQUIRED);
		}
	}

	@Override
	protected void createParameters(Map<String, String> parameters) {
		parameters.put("num_minutes", num_minutes);
	}

}
