package allbegray.slack.webapi.method.chats;

import allbegray.slack.exception.SlackException;
import allbegray.slack.type.Attachment;
import allbegray.slack.validation.Problem;
import allbegray.slack.validation.ValidationError;
import allbegray.slack.webapi.SlackWebApiConstants;
import allbegray.slack.webapi.method.AbstractMethod;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

public class ChatUnfurlMethod extends AbstractMethod {
    protected String channel;
    protected String ts;
    protected Map<String, Attachment> unfurlResponseMap;
    protected boolean user_auth_required;
    protected ObjectMapper mapper;

    public ChatUnfurlMethod(String channel, String ts, Map<String, Attachment> unfurlResponseMap, boolean user_auth_required) {
        this.channel = channel;
        this.ts = ts;
        this.unfurlResponseMap = unfurlResponseMap;
        this.user_auth_required = user_auth_required;
    }

    @Override
    public String getMethodName() {
        return SlackWebApiConstants.CHAT_UNFURL;
    }

    @Override
    public void validate(List<ValidationError> errors) {
        if (unfurlResponseMap == null || unfurlResponseMap.isEmpty()) {
            addError(errors, "unfurlResponseMap", Problem.REQUIRED);
        }
    }

    @Override
    protected void createParameters(Map<String, String> parameters) {
        parameters.put("channel", channel);
        parameters.put("ts", ts);
        parameters.put("user_auth_required", Boolean.toString(user_auth_required));

        try {
            parameters.put("unfurls", mapper.writeValueAsString(unfurlResponseMap));
        } catch (JsonProcessingException e) {
            throw new SlackException(e);
        }
    }

    public void setMapper(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public boolean isRequiredUserToken() {
        return true;
    }
}
