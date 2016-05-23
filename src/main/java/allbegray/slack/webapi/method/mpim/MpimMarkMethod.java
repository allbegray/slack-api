package allbegray.slack.webapi.method.mpim;

import allbegray.slack.webapi.SlackWebApiConstants;
import allbegray.slack.webapi.method.im.ImMarkMethod;

public class MpimMarkMethod extends ImMarkMethod {

	public MpimMarkMethod(String channel, String ts) {
		super(channel, ts);
	}

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.MPIM_MARK;
	}

}
