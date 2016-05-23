package allbegray.slack.webapi.method.mpim;

import allbegray.slack.webapi.SlackWebApiConstants;
import allbegray.slack.webapi.method.im.ImHistoryMethod;

public class MpimHistoryMethod extends ImHistoryMethod {

	public MpimHistoryMethod(String channel) {
		super(channel);
	}

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.MPIM_HISTORY;
	}

}
