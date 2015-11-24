package flowctrl.integration.slack.webapi.method.search;

import flowctrl.integration.slack.webapi.SlackWebApiConstants;
import flowctrl.integration.slack.webapi.method.AbstractSearchMethod;

public class SearchFileMethod extends AbstractSearchMethod {

	public SearchFileMethod(String query) {
		super(query);
	}

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.SEARCH_FILES;
	}

}
