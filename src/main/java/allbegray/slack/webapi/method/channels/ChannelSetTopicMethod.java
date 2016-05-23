package allbegray.slack.webapi.method.channels;

import java.util.List;
import java.util.Map;

import allbegray.slack.validation.Problem;
import allbegray.slack.validation.ValidationError;
import allbegray.slack.webapi.SlackWebApiConstants;
import allbegray.slack.webapi.method.AbstractMethod;

public class ChannelSetTopicMethod extends AbstractMethod {

	public ChannelSetTopicMethod(String channel, String topic) {
		this.channel = channel;
		this.topic = topic;
	}

	protected String channel;
	protected String topic;

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.CHANNELS_SET_TOPIC;
	}

	@Override
	public void validate(List<ValidationError> errors) {
		if (channel == null) {
			addError(errors, "channel", Problem.REQUIRED);
		}
		if (topic == null) {
			addError(errors, "topic", Problem.REQUIRED);
		}
	}

	@Override
	protected void createParameters(Map<String, String> parameters) {
		parameters.put("channel", channel);
		parameters.put("topic", topic);
	}

}
