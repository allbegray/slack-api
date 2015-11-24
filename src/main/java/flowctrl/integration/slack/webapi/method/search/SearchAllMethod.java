package flowctrl.integration.slack.webapi.method.search;

import flowctrl.integration.slack.webapi.SlackWebApiConstants;
import flowctrl.integration.slack.webapi.method.AbstractSearchMethod;

public class SearchAllMethod extends AbstractSearchMethod {

	public SearchAllMethod(String query) {
		super(query);
	}

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.SEARCH_ALL;
	}

}
