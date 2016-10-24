package allbegray.slack.webapi.method.users.profile;

import allbegray.slack.validation.ValidationError;
import allbegray.slack.webapi.SlackWebApiConstants;
import allbegray.slack.webapi.method.AbstractMethod;

import java.util.List;
import java.util.Map;

/**
 * Created by allbegray on 2016-10-24.
 */
public class UserProfileGetMethoad extends AbstractMethod {

    protected String user;
    protected boolean include_labels;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public boolean isInclude_labels() {
        return include_labels;
    }

    public void setInclude_labels(boolean include_labels) {
        this.include_labels = include_labels;
    }

    @Override
    public String getMethodName() {
        return SlackWebApiConstants.USERS_PROFILE_GET;
    }

    @Override
    public void validate(List<ValidationError> errors) {

    }

    @Override
    protected void createParameters(Map<String, String> parameters) {
        if (user != null) {
            parameters.put("user", user);
        }
        if (include_labels) {
            parameters.put("include_labels", "1");
        }
    }

}
