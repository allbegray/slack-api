package allbegray.slack.webapi.method.users.profile;

import allbegray.slack.validation.ValidationError;
import allbegray.slack.webapi.SlackWebApiConstants;
import allbegray.slack.webapi.method.AbstractMethod;

import java.util.List;
import java.util.Map;

/**
 * Created by allbegray on 2016-10-24.
 */
public class UserProfileSetMethoad extends AbstractMethod {

    protected String user;
    protected String profile;
    protected String name;
    protected String value;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String getMethodName() {
        return SlackWebApiConstants.USERS_PROFILE_SET;
    }

    @Override
    public void validate(List<ValidationError> errors) {

    }

    @Override
    protected void createParameters(Map<String, String> parameters) {
        if (user != null) {
            parameters.put("user", user);
        }
        if (profile != null) {
            parameters.put("profile", profile);
        }
        if (name != null) {
            parameters.put("name", name);
        }
        if (value != null) {
            parameters.put("value", value);
        }
    }

}
