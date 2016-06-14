package allbegray.slack.webapi.method.bots;

import allbegray.slack.validation.ValidationError;
import allbegray.slack.webapi.SlackWebApiConstants;
import allbegray.slack.webapi.method.AbstractMethod;

import java.util.List;
import java.util.Map;

/**
 * Created by allbegray on 2016-06-14.
 */
public class BotInfoMethod extends AbstractMethod {

    protected String bot;

    public String getBot() {
        return bot;
    }

    public void setBot(String bot) {
        this.bot = bot;
    }

    @Override
    public String getMethodName() {
        return SlackWebApiConstants.BOTS_INFO;
    }

    @Override
    public void validate(List<ValidationError> errors) {
        // ignore
    }

    @Override
    protected void createParameters(Map<String, String> parameters) {
        if (bot != null) {
            parameters.put("bot", bot);
        }
    }

}
