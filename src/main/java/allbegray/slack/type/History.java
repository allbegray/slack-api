package allbegray.slack.type;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class History {

	protected String latest;
	protected List<Message> messages;
	protected Boolean has_more;

	public String getLatest() {
		return latest;
	}

	public void setLatest(String latest) {
		this.latest = latest;
	}

	public List<Message> getMessages() {
		if (messages == null) {
			messages = new ArrayList<Message>();
		}
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public Boolean getHas_more() {
		return has_more;
	}

	public void setHas_more(Boolean has_more) {
		this.has_more = has_more;
	}

	@Override
	public String toString() {
		return "ChannelHistory [latest=" + latest + ", messages=" + messages + ", has_more=" + has_more + "]";
	}

}
