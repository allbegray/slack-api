package flowctrl.integration.slack.webapi.method.mpim;

import flowctrl.integration.slack.webapi.SlackWebApiConstants;
import flowctrl.integration.slack.webapi.method.im.ImHistoryMethod;

public class MpimHistoryMethod extends ImHistoryMethod {

	public MpimHistoryMethod(String channel) {
		super(channel);
	}

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.MPIM_HISTORY;
	}

}
