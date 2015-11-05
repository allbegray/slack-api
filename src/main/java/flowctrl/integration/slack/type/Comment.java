package flowctrl.integration.slack.type;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Comment {

	protected String id;
	protected String created;
	protected String timestamp;
	protected String user;
	protected String comment;
	protected List<String> pinned_to;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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

	@Override
	public String toString() {
		return "Comment [id=" + id + ", created=" + created + ", timestamp=" + timestamp + ", user=" + user + ", comment=" + comment + ", pinned_to=" + pinned_to + "]";
	}

}
