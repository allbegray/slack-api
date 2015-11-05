package flowctrl.integration.slack.webapi.method.groups;

import flowctrl.integration.slack.webapi.SlackWebApiConstants;
import flowctrl.integration.slack.webapi.method.channels.ChannelSetTopicMethod;

public class GroupSetTopicMethod extends ChannelSetTopicMethod {

	public GroupSetTopicMethod(String channel, String topic) {
		super(channel, topic);
	}

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.GROUPS_SET_TOPIC;
	}

}
