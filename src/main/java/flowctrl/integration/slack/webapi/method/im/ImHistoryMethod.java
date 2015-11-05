package flowctrl.integration.slack.webapi.method.im;

import flowctrl.integration.slack.webapi.SlackWebApiConstants;
import flowctrl.integration.slack.webapi.method.AbstractHistoryMethod;

public class ImHistoryMethod extends AbstractHistoryMethod {

	public ImHistoryMethod(String channel) {
		super(channel);
	}

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.IM_HISTORY;
	}

}
