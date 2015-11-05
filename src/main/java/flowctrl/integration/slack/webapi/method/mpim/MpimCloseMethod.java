package flowctrl.integration.slack.webapi.method.mpim;

import flowctrl.integration.slack.webapi.SlackWebApiConstants;
import flowctrl.integration.slack.webapi.method.im.ImCloseMethod;

public class MpimCloseMethod extends ImCloseMethod {

	public MpimCloseMethod(String channel) {
		super(channel);
	}

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.MPIM_CLOSE;
	}

}
