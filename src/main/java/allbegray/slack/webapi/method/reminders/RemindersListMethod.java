package allbegray.slack.webapi.method.reminders;

import allbegray.slack.validation.ValidationError;
import allbegray.slack.webapi.SlackWebApiConstants;
import allbegray.slack.webapi.method.AbstractMethod;

import java.util.List;
import java.util.Map;

public class RemindersListMethod extends AbstractMethod {


    @Override
    public String getMethodName() {
        return SlackWebApiConstants.REMINDERS_LIST;
    }

    @Override
    public void validate(List<ValidationError> errors) {

    }

    @Override
    protected void createParameters(Map<String, String> parameters) {
    }

}
