package allbegray.slack.type;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReactionItem {

	protected String type;
	protected String channel;
	protected Message message;
	protected File file;
	protected List<Reaction> reactions;
	protected Comment comment;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
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

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "ReactionItem [type=" + type + ", channel=" + channel + ", message=" + message + ", file=" + file + ", reactions=" + reactions + ", comment=" + comment + "]";
	}

}
