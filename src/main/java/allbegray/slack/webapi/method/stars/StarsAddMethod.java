package allbegray.slack.webapi.method.stars;

import allbegray.slack.webapi.SlackWebApiConstants;
import allbegray.slack.webapi.method.AbstractItemMethod;

public class StarsAddMethod extends AbstractItemMethod {

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.STARS_ADD;
	}

}
