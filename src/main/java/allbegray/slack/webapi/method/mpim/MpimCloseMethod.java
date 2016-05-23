package allbegray.slack.webapi.method.mpim;

import allbegray.slack.webapi.SlackWebApiConstants;
import allbegray.slack.webapi.method.im.ImCloseMethod;

public class MpimCloseMethod extends ImCloseMethod {

	public MpimCloseMethod(String channel) {
		super(channel);
	}

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.MPIM_CLOSE;
	}

}
