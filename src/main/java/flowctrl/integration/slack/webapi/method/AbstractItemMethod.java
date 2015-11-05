package flowctrl.integration.slack.webapi.method;

import java.util.List;
import java.util.Map;

import flowctrl.integration.slack.validation.Problem;
import flowctrl.integration.slack.validation.ValidationError;

public abstract class AbstractItemMethod extends AbstractMethod {

	protected String file;
	protected String file_comment;
	protected String channel;
	protected String timestamp;

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getFile_comment() {
		return file_comment;
	}

	public void setFile_comment(String file_comment) {
		this.file_comment = file_comment;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public void validate(List<ValidationError> errors) {
		if (((file == null && file_comment == null) && (channel == null || timestamp == null)) || (file != null && file_comment != null)) {
			addError(errors, "file, file_comment, channel, timestamp", Problem.REQUIRED, "one of \"file\", \"file_comment\", or the combination of \"channel\" and \"timestamp\" must be specified.");
		}
	}

	@Override
	protected void createParameters(Map<String, String> parameters) {
		if (file != null) {
			parameters.put("file", file);
		}
		if (file_comment != null) {
			parameters.put("file_comment", file_comment);
		}
		if (channel != null) {
			parameters.put("channel", channel);
		}
		if (timestamp != null) {
			parameters.put("timestamp", timestamp);
		}
	}

}
