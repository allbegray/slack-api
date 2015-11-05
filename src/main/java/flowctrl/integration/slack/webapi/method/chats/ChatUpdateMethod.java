package flowctrl.integration.slack.webapi.method.chats;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import flowctrl.integration.slack.exception.SlackException;
import flowctrl.integration.slack.type.Attachment;
import flowctrl.integration.slack.validation.Problem;
import flowctrl.integration.slack.validation.ValidationError;
import flowctrl.integration.slack.webapi.SlackWebApiConstants;
import flowctrl.integration.slack.webapi.method.AbstractMethod;

public class ChatUpdateMethod extends AbstractMethod {

	protected ObjectMapper mapper;

	public ObjectMapper getMapper() {
		return mapper;
	}

	public void setMapper(ObjectMapper mapper) {
		this.mapper = mapper;
	}

	public ChatUpdateMethod(String channel, String ts, String text) {
		this.channel = channel;
		this.ts = ts;
		this.text = text;
	}

	protected String channel;
	protected String ts;
	protected String text;
	protected List<Attachment> attachments;
	protected boolean link_names;

	public String getTs() {
		return ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}

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

	public List<Attachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}

	public boolean isLink_names() {
		return link_names;
	}

	public void setLink_names(boolean link_names) {
		this.link_names = link_names;
	}

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.CHAT_UPDATE;
	}

	@Override
	public void validate(List<ValidationError> errors) {
		if (channel == null) {
			addError(errors, "channel", Problem.REQUIRED, null);
		}
		if (ts == null) {
			addError(errors, "ts", Problem.REQUIRED, null);
		}
		if (text == null) {
			addError(errors, "text", Problem.REQUIRED, null);
		}
	}

	@Override
	protected void createParameters(Map<String, String> parameters) {
		parameters.put("ts", ts);
		parameters.put("channel", channel);
		parameters.put("text", text);

		if (attachments != null && !attachments.isEmpty()) {
			try {
				parameters.put("attachments", mapper.writeValueAsString(attachments));
			} catch (JsonProcessingException e) {
				throw new SlackException(e);
			}
		}

		if (link_names) {
			parameters.put("link_names", "1");
			parameters.put("parse", "full");
		} else {
			parameters.put("parse", "none");
		}

	}

}
