package flowctrl.integration.slack.type;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import flowctrl.integration.slack.exception.SlackArgumentException;
import flowctrl.integration.slack.webhook.SlackWebhookClient;

/**
 * reference :
 * <a href="https://api.slack.com/docs/attachments">https://api.slack.com/docs/
 * attachments</a>
 *
 */
@JsonInclude(Include.NON_EMPTY)
public class Attachment {

	private static final String HEX_REGEX = "^([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$";
	private static final String PREDEFINED_COLOR_REGEX = "^(good|warning|danger)$";

	protected String fallback;

	protected String color;

	protected String pretext;

	protected String author_name;
	protected String author_link;
	protected String author_icon;

	protected String title;
	protected String title_link;

	protected String text;

	protected List<Field> fields;

	protected String image_url;
	protected String thumb_url;

	protected List<String> mrkdwn_in;

	public String getFallback() {
		return fallback;
	}

	public void setFallback(String fallback) {
		this.fallback = fallback;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		if (color != null) {
			if (color.charAt(0) == '#') {
				if (color.substring(1).matches(HEX_REGEX)) {
					throw new SlackArgumentException("invalid hex color");
				}
			} else if (!color.matches(PREDEFINED_COLOR_REGEX)) {
				throw new SlackArgumentException("invalid predefined(good|warning|danger) color");
			}
		}

		this.color = color;
	}

	public void setColor(Color color) {
		if (color != null) {
			this.color = color.name().toLowerCase();
		}
	}

	public String getPretext() {
		return pretext;
	}

	public void setPretext(String pretext) {
		this.pretext = pretext;
	}

	public String getAuthor_name() {
		return author_name;
	}

	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}

	public String getAuthor_link() {
		return author_link;
	}

	public void setAuthor_link(String author_link) {
		SlackWebhookClient.validUrl(author_link, "author_link");

		this.author_link = author_link;
	}

	public String getAuthor_icon() {
		return author_icon;
	}

	public void setAuthor_icon(String author_icon) {
		SlackWebhookClient.validUrl(author_icon, "author_icon");

		this.author_icon = author_icon;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle_link() {
		return title_link;
	}

	public void setTitle_link(String title_link) {
		SlackWebhookClient.validUrl(title_link, "title_link");

		this.title_link = title_link;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void addField(Field field) {
		getFields().add(field);
	}

	public List<Field> getFields() {
		if (fields == null) {
			fields = new ArrayList<Field>();
		}
		return fields;
	}

	public void setFields(List<Field> fields) {
		this.fields = fields;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		SlackWebhookClient.validUrl(image_url, "image_url");

		this.image_url = image_url;
	}

	public String getThumb_url() {
		return thumb_url;
	}

	public void setThumb_url(String thumb_url) {
		SlackWebhookClient.validUrl(thumb_url, "thumb_url");

		this.thumb_url = thumb_url;
	}

	public void addMrkdwn_in(String field) {
		getMrkdwn_in().add(field);
	}

	public List<String> getMrkdwn_in() {
		if (mrkdwn_in == null) {
			mrkdwn_in = new ArrayList<String>();
		}
		return mrkdwn_in;
	}

	public void setMrkdwn_in(List<String> mrkdwn_in) {
		this.mrkdwn_in = mrkdwn_in;
	}

	@Override
	public String toString() {
		return "Attachment [fallback=" + fallback + ", color=" + color + ", pretext=" + pretext + ", author_name=" + author_name + ", author_link=" + author_link + ", author_icon=" + author_icon
				+ ", title=" + title + ", title_link=" + title_link + ", text=" + text + ", fields=" + fields + ", image_url=" + image_url + ", thumb_url=" + thumb_url + ", mrkdwn_in=" + mrkdwn_in
				+ "]";
	}

}
