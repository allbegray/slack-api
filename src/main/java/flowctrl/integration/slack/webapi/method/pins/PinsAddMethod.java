package flowctrl.integration.slack.webapi.method.pins;

import java.util.List;
import java.util.Map;

import flowctrl.integration.slack.validation.Problem;
import flowctrl.integration.slack.validation.ValidationError;
import flowctrl.integration.slack.webapi.SlackWebApiConstants;
import flowctrl.integration.slack.webapi.method.AbstractMethod;

public class PinsAddMethod extends AbstractMethod {

	public PinsAddMethod(String channel) {
		this.channel = channel;
	}

	protected String channel;
	protected String file;
	protected String file_comment;
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
	public String getMethodName() {
		return SlackWebApiConstants.PINS_ADD;
	}

	@Override
	public void validate(List<ValidationError> errors) {
		if (channel == null) {
			addError(errors, "channel", Problem.REQUIRED, null);
		}
		if (file == null && file_comment == null && timestamp == null) {
			addError(errors, "file, file_comment, timestamp", Problem.REQUIRED, "one of \"file\", \"file_comment\", or \"timestamp\" must also be specified");
		}
	}

	@Override
	protected void createParameters(Map<String, String> parameters) {
		parameters.put("channel", channel);
		if (file != null) {
			parameters.put("file", file);
		}
		if (file_comment != null) {
			parameters.put("file_comment", file_comment);
		}
		if (timestamp != null) {
			parameters.put("timestamp", timestamp);
		}
	}

}
