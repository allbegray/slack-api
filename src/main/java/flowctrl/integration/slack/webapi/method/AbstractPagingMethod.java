package flowctrl.integration.slack.webapi.method;

import java.util.List;
import java.util.Map;

import flowctrl.integration.slack.validation.Problem;
import flowctrl.integration.slack.validation.ValidationError;
import flowctrl.integration.slack.webapi.SlackWebApiConstants;

public abstract class AbstractPagingMethod extends AbstractMethod {

	protected Integer count;
	protected Integer page;

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	@Override
	public void validate(List<ValidationError> errors) {
		if (count != null && count < 1) {
			addError(errors, "count", Problem.PATTERN_NOT_MATCH, "\"count\" must be greater than 0.");
		}
		if (page != null && page < 1) {
			addError(errors, "page", Problem.PATTERN_NOT_MATCH, "\"page\" must be greater than 0.");
		}
	}

	@Override
	protected void createParameters(Map<String, String> parameters) {
		parameters.put("count", count != null ? String.valueOf(count) : String.valueOf(SlackWebApiConstants.DEFAULT_COUNT));
		parameters.put("page", page != null ? String.valueOf(page) : String.valueOf(SlackWebApiConstants.DEFAULT_PAGE));
	}

}
