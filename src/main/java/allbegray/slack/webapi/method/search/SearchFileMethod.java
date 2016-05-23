package allbegray.slack.webapi.method.search;

import allbegray.slack.webapi.method.AbstractSearchMethod;
import allbegray.slack.webapi.SlackWebApiConstants;

public class SearchFileMethod extends AbstractSearchMethod {

	public SearchFileMethod(String query) {
		super(query);
	}

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.SEARCH_FILES;
	}

}
