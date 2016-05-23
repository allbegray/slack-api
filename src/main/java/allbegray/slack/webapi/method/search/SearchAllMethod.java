package allbegray.slack.webapi.method.search;

import allbegray.slack.webapi.SlackWebApiConstants;
import allbegray.slack.webapi.method.AbstractSearchMethod;

public class SearchAllMethod extends AbstractSearchMethod {

	public SearchAllMethod(String query) {
		super(query);
	}

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.SEARCH_ALL;
	}

}
