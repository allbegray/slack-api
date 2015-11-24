package flowctrl.integration.slack.webapi.method.search;

import flowctrl.integration.slack.webapi.SlackWebApiConstants;
import flowctrl.integration.slack.webapi.method.AbstractSearchMethod;

public class SearchMessageMethod extends AbstractSearchMethod {

	public SearchMessageMethod(String query) {
		super(query);
	}

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.SEARCH_MESSAGES;
	}

}
