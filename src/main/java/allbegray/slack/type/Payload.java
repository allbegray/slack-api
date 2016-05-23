package allbegray.slack.type;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import allbegray.slack.exception.SlackArgumentException;
import allbegray.slack.validation.SlackFieldValidationUtils;

/**
 * reference :
 * <a href="https://api.slack.com/incoming-webhooks">https://api.slack.com/
 * incoming-webhooks</a>
 *
 */
@JsonInclude(Include.NON_EMPTY)
public class Payload {

	protected String username;
	protected String text;
	protected String icon_url;
	protected String icon_emoji;
	protected String channel;
	protected List<Attachment> attachments;

	protected Boolean unfurl_links;
	protected Boolean unfurl_media;
	protected Boolean mrkdwn;

	public Boolean getMrkdwn() {
		return mrkdwn;
	}

	public void setMrkdwn(Boolean mrkdwn) {
		this.mrkdwn = mrkdwn;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getIcon_url() {
		return icon_url;
	}

	public void setIcon_url(String icon_url) {
		SlackFieldValidationUtils.validUrl(icon_url, "icon_url");

		this.icon_url = icon_url;
	}

	public String getIcon_emoji() {
		return icon_emoji;
	}

	/**
	 * reference :
	 * <a href="http://www.emoji-cheat-sheet.com">http://www.emoji-cheat-sheet.
	 * com</a>
	 */
	public void setIcon_emoji(String icon_emoji) {
		if (icon_emoji != null && (!icon_emoji.startsWith(":") || !icon_emoji.endsWith(":"))) {
			throw new SlackArgumentException("invalid icon_emoji. you should start and end with \":\". ex):sunny:");
		}
		this.icon_emoji = icon_emoji;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		if (channel != null && !(channel.startsWith("#") || channel.startsWith("@"))) {
			throw new SlackArgumentException("invalid channel. you should start with \"#\" or \"@\". ex)#channelname, @username");
		}

		this.channel = channel;
	}

	public void addAttachment(Attachment attachment) {
		getAttachments().add(attachment);
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

	public Boolean getUnfurl_links() {
		return unfurl_links;
	}

	public void setUnfurl_links(Boolean unfurl_links) {
		this.unfurl_links = unfurl_links;
	}

	public Boolean getUnfurl_media() {
		return unfurl_media;
	}

	public void setUnfurl_media(Boolean unfurl_media) {
		this.unfurl_media = unfurl_media;
	}

	@Override
	public String toString() {
		return "SlackPayload [username=" + username + ", text=" + text + ", icon_url=" + icon_url + ", icon_emoji=" + icon_emoji + ", channel=" + channel + ", attachments=" + attachments
				+ ", unfurl_links=" + unfurl_links + ", unfurl_media=" + unfurl_media + "]";
	}

}
