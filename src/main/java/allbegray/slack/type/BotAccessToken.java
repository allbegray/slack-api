package allbegray.slack.type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BotAccessToken {
    protected String bot_access_token;
    protected String bot_user_id;

    public String getBot_access_token() {
        return bot_access_token;
    }

    public void setBot_access_token(String bot_access_token) {
        this.bot_access_token = bot_access_token;
    }

    public String getBot_user_id() {
        return bot_user_id;
    }

    public void setBot_user_id(String bot_user_id) {
        this.bot_user_id = bot_user_id;
    }

    @Override
    public String toString() {
        return "BotAccessToken [bot_user_id=" + bot_user_id + ", bot_access_token=" + bot_access_token + "]";
    }
}
