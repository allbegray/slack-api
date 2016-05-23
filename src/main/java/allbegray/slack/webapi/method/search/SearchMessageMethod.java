package allbegray.slack.webapi.method.search;

import allbegray.slack.webapi.method.AbstractSearchMethod;
import allbegray.slack.webapi.SlackWebApiConstants;

public class SearchMessageMethod extends AbstractSearchMethod {

	public SearchMessageMethod(String query) {
		super(query);
	}

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.SEARCH_MESSAGES;
	}

}
