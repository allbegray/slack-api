package allbegray.slack.webapi.method.chats;

import allbegray.slack.validation.Problem;
import allbegray.slack.validation.ValidationError;
import allbegray.slack.webapi.SlackWebApiConstants;
import allbegray.slack.webapi.method.AbstractMethod;

import java.util.List;
import java.util.Map;

/**
 * Created by allbegray on 2016-06-14.
 */
public class ChatMeMessageMethod extends AbstractMethod {

    public ChatMeMessageMethod(String channel, String text) {
        this.channel = channel;
        this.text = text;
    }

    protected String channel;
    protected String text;

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String getMethodName() {
        return SlackWebApiConstants.CHAT_ME_MESSAGE;
    }

    @Override
    public void validate(List<ValidationError> errors) {
        if (channel == null) {
            addError(errors, "channel", Problem.REQUIRED);
        }
        if (text == null) {
            addError(errors, "text", Problem.REQUIRED);
        }
    }

    @Override
    protected void createParameters(Map<String, String> parameters) {
        parameters.put("channel", channel);
        parameters.put("text", text);
    }

}
