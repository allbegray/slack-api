package flowctrl.integration.slack.webapi.method.chats;

import java.util.ArrayList;
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

public class ChatPostMessageMethod extends AbstractMethod {

	protected ObjectMapper mapper;

	public ObjectMapper getMapper() {
		return mapper;
	}

	public void setMapper(ObjectMapper mapper) {
		this.mapper = mapper;
	}

	public ChatPostMessageMethod(String channel, String text) {
		this.channel = channel;
		this.text = text;
	}

	protected String channel;
	protected String text;
	protected String username;
	protected boolean as_user;
	protected boolean link_names;
	protected List<Attachment> attachments;
	protected boolean unfurl_links;
	protected boolean unfurl_media;
	protected String icon_url;
	protected String icon_emoji;

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isAs_user() {
		return as_user;
	}

	public void setAs_user(boolean as_user) {
		this.as_user = as_user;
	}

	public boolean isLink_names() {
		return link_names;
	}

	public void setLink_names(boolean link_names) {
		this.link_names = link_names;
	}

	public List<Attachment> getAttachments() {
		if (attachments == null) {
			attachments = new ArrayList<Attachment>();
		}
		return attachments;
	}

	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}

	public boolean isUnfurl_links() {
		return unfurl_links;
	}

	public void setUnfurl_links(boolean unfurl_links) {
		this.unfurl_links = unfurl_links;
	}

	public boolean isUnfurl_media() {
		return unfurl_media;
	}

	public void setUnfurl_media(boolean unfurl_media) {
		this.unfurl_media = unfurl_media;
	}

	public String getIcon_url() {
		return icon_url;
	}

	public void setIcon_url(String icon_url) {
		this.icon_url = icon_url;
	}

	public String getIcon_emoji() {
		return icon_emoji;
	}

	public void setIcon_emoji(String icon_emoji) {
		this.icon_emoji = icon_emoji;
	}

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.CHAT_POST_MESSAGE;
	}

	@Override
	public void validate(List<ValidationError> errors) {
		if (channel == null) {
			addError(errors, "channel", Problem.REQUIRED, null);
		}
		if (text == null) {
			addError(errors, "text", Problem.REQUIRED, null);
		}
	}

	@Override
	protected void createParameters(Map<String, String> parameters) {
		parameters.put("channel", channel);
		parameters.put("text", text);
		parameters.put("username", username);
		parameters.put("as_user", String.valueOf(as_user));

		if (link_names) {
			parameters.put("link_names", "1");
			parameters.put("parse", "full");
		} else {
			parameters.put("parse", "none");
		}

		if (attachments != null && !attachments.isEmpty()) {
			try {
				parameters.put("attachments", mapper.writeValueAsString(attachments));
			} catch (JsonProcessingException e) {
				throw new SlackException(e);
			}
		}

		parameters.put("unfurl_links", String.valueOf(unfurl_links));
		parameters.put("unfurl_media", String.valueOf(unfurl_media));
		parameters.put("icon_url", icon_url);
		parameters.put("icon_emoji", icon_emoji);
	}

}
