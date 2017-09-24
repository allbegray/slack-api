package allbegray.slack.webapi.method.chats;

import allbegray.slack.exception.SlackException;
import allbegray.slack.type.Attachment;
import allbegray.slack.validation.ValidationError;
import allbegray.slack.webapi.SlackWebApiConstants;
import allbegray.slack.webapi.method.AbstractMethod;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ChatPostEphemeral extends AbstractMethod {
    protected String channel;
    protected String user;
    protected String text;
    protected List<Attachment> attachments;

    protected ObjectMapper mapper;

    public ChatPostEphemeral(String channel, String user) {
        this.channel = channel;
        this.user = user;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

    public void addAttachment(Attachment attachment) {
        if (attachments == null) {
            attachments = new ArrayList<>();
        }
        attachments.add(attachment);
    }

    @Override
    public String getMethodName() {
        return SlackWebApiConstants.CHAT_POST_EPHEMERAL;
    }

    @Override
    public void validate(List<ValidationError> errors) {

    }

    @Override
    protected void createParameters(Map<String, String> parameters) {
        parameters.put("channel", channel);
        parameters.put("user", user);
        parameters.put("text", text);

        if (attachments != null && !attachments.isEmpty()) {
            try {
                parameters.put("attachments", mapper.writeValueAsString(attachments));
            } catch (JsonProcessingException e) {
                throw new SlackException(e);
            }
        }
    }
}
