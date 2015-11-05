package flowctrl.integration.slack.webapi.method.mpim;

import flowctrl.integration.slack.webapi.SlackWebApiConstants;
import flowctrl.integration.slack.webapi.method.im.ImListMethod;

public class MpimListMethod extends ImListMethod {

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.MPIM_LIST;
	}

}
