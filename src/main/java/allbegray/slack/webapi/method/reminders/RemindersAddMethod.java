package allbegray.slack.webapi.method.reminders;

import allbegray.slack.validation.Problem;
import allbegray.slack.validation.ValidationError;
import allbegray.slack.webapi.SlackWebApiConstants;
import allbegray.slack.webapi.method.AbstractMethod;

import java.util.List;
import java.util.Map;

public class RemindersAddMethod extends AbstractMethod {

    public RemindersAddMethod(String text, long time) {
        this.text = text;
        this.time = time;
    }

    public RemindersAddMethod(String text, String time) {
        this.text = text;
        this.time = time;
    }

    protected String text;
    protected Object time;


    @Override
    public String getMethodName() {
        return SlackWebApiConstants.REMINDERS_ADD;
    }

    @Override
    public void validate(List<ValidationError> errors) {
        if (text == null) {
            addError(errors, "text", Problem.REQUIRED);
        }
    }

    @Override
    protected void createParameters(Map<String, String> parameters) {
        parameters.put("text", text);
        parameters.put("time", "" + time);
    }

}
