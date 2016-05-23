package allbegray.slack.webapi.method.groups;

import allbegray.slack.webapi.method.channels.ChannelSetTopicMethod;
import allbegray.slack.webapi.SlackWebApiConstants;

public class GroupSetTopicMethod extends ChannelSetTopicMethod {

	public GroupSetTopicMethod(String channel, String topic) {
		super(channel, topic);
	}

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.GROUPS_SET_TOPIC;
	}

}
