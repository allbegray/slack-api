package flowctrl.integration.slack.webapi.method.mpim;

import flowctrl.integration.slack.webapi.SlackWebApiConstants;
import flowctrl.integration.slack.webapi.method.im.ImMarkMethod;

public class MpimMarkMethod extends ImMarkMethod {

	public MpimMarkMethod(String channel, String ts) {
		super(channel, ts);
	}

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.MPIM_MARK;
	}

}
