package allbegray.slack.webapi.method.mpim;

import allbegray.slack.webapi.SlackWebApiConstants;
import allbegray.slack.webapi.method.im.ImListMethod;

public class MpimListMethod extends ImListMethod {

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.MPIM_LIST;
	}

}
