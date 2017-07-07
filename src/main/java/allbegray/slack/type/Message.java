package allbegray.slack.type;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Message {

	protected String type;
	protected String ts;
	protected String user;
	protected String text;
	protected String thread_ts;

	protected Boolean is_starred;
	protected String subtype;
	protected String username;
	protected String permalink;
	protected List<String> pinned_to;
	protected List<Reaction> reactions;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTs() {
		return ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getThread_ts() {
		return thread_ts;
	}

	public void setThread_ts(String thread_ts) {
		this.thread_ts = thread_ts;
	}

	public String getPermalink() {
		return permalink;
	}

	public void setPermalink(String permalink) {
		this.permalink = permalink;
	}

	public List<String> getPinned_to() {
		if (pinned_to == null) {
			pinned_to = new ArrayList<String>();
		}
		return pinned_to;
	}

	public void setPinned_to(List<String> pinned_to) {
		this.pinned_to = pinned_to;
	}

	public String getSubtype() {
		return subtype;
	}

	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Reaction> getReactions() {
		if (reactions == null) {
			reactions = new ArrayList<Reaction>();
		}
		return reactions;
	}

	public void setReactions(List<Reaction> reactions) {
		this.reactions = reactions;
	}

	public Boolean getIs_starred() {
		return is_starred;
	}

	public void setIs_starred(Boolean is_starred) {
		this.is_starred = is_starred;
	}

	@Override
	public String toString() {
		return "Message [type=" + type + ", ts=" + ts + ", user=" + user + ", text=" + text + ", is_starred=" + is_starred + ", subtype=" + subtype + ", username=" + username + ", permalink="
				+ permalink + ", pinned_to=" + pinned_to + ", reactions=" + reactions + "]";
	}

}
