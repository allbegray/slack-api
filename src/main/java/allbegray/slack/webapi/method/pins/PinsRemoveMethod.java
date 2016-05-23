package allbegray.slack.webapi.method.pins;

import allbegray.slack.webapi.SlackWebApiConstants;

public class PinsRemoveMethod extends PinsAddMethod {

	public PinsRemoveMethod(String channel) {
		super(channel);
	}

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.PINS_REMOVE;
	}

}
