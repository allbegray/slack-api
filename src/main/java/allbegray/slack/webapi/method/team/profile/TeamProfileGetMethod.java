package allbegray.slack.webapi.method.team.profile;

import allbegray.slack.validation.ValidationError;
import allbegray.slack.webapi.SlackWebApiConstants;
import allbegray.slack.webapi.method.AbstractMethod;

import java.util.List;
import java.util.Map;

/**
 * Created by allbegray on 2016-10-24.
 */
public class TeamProfileGetMethod extends AbstractMethod {

    enum Visibility {
        all, visibility, hidden;
    }

    protected Visibility visibility;

    public Visibility getVisibility() {
        return visibility;
    }

    public void setVisibility(Visibility visibility) {
        this.visibility = visibility;
    }

    @Override
    public String getMethodName() {
        return SlackWebApiConstants.TEAM_PROFILE_GET;
    }

    @Override
    public void validate(List<ValidationError> errors) {

    }

    @Override
    protected void createParameters(Map<String, String> parameters) {
        if (visibility != null) {
            parameters.put("visibility", visibility.name());
        }
    }

}
