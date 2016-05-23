package allbegray.slack.webapi.method.chats;

import java.util.List;
import java.util.Map;

import allbegray.slack.validation.Problem;
import allbegray.slack.validation.ValidationError;
import allbegray.slack.webapi.SlackWebApiConstants;
import allbegray.slack.webapi.method.AbstractMethod;

public class ChatDeleteMethod extends AbstractMethod {

	public ChatDeleteMethod(String channel, String ts) {
		this.channel = channel;
		this.ts = ts;
	}

	protected String channel;
	protected String ts;

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getTs() {
		return ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.CHAT_DELETE;
	}

	@Override
	public void validate(List<ValidationError> errors) {
		if (channel == null) {
			addError(errors, "channel", Problem.REQUIRED);
		}
		if (ts == null) {
			addError(errors, "ts", Problem.REQUIRED);
		}
	}

	@Override
	protected void createParameters(Map<String, String> parameters) {
		parameters.put("channel", channel);
		parameters.put("ts", ts);
	}

}
