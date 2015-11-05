package flowctrl.integration.slack.webapi.method.stars;

import flowctrl.integration.slack.webapi.SlackWebApiConstants;
import flowctrl.integration.slack.webapi.method.AbstractItemMethod;

public class StarsAddMethod extends AbstractItemMethod {

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.STARS_ADD;
	}

}
