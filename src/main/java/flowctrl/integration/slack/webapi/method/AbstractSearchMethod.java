package flowctrl.integration.slack.webapi.method;

import java.util.List;
import java.util.Map;

import flowctrl.integration.slack.validation.Problem;
import flowctrl.integration.slack.validation.ValidationError;

public abstract class AbstractSearchMethod extends AbstractPagingMethod {

	public AbstractSearchMethod(String query) {
		super();
		this.query = query;
	}

	protected String query;
	protected String sort;
	protected String sort_dir;
	protected boolean highlight;

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getSort_dir() {
		return sort_dir;
	}

	public void setSort_dir(String sort_dir) {
		this.sort_dir = sort_dir;
	}

	public boolean isHighlight() {
		return highlight;
	}

	public void setHighlight(boolean highlight) {
		this.highlight = highlight;
	}

	@Override
	public void validate(List<ValidationError> errors) {
		super.validate(errors);
		if (query == null) {
			addError(errors, "query", Problem.REQUIRED);
		}
		if (sort != null && !("timestamp".equalsIgnoreCase(sort) || "score".equalsIgnoreCase(sort))) {
			addError(errors, "sort", Problem.PATTERN_NOT_MATCH, "\"sort\" must be either \"timestamp\" or \"score\".");
		}
		if (sort_dir != null && !("asc".equalsIgnoreCase(sort_dir) || "desc".equalsIgnoreCase(sort_dir))) {
			addError(errors, "sort_dir", Problem.PATTERN_NOT_MATCH, "\"sort_dir\" must be either \"asc\" or \"desc\".");
		}
	}

	@Override
	protected void createParameters(Map<String, String> parameters) {
		super.createParameters(parameters);
		parameters.put("query", query);
		if (sort != null) {
			parameters.put("sort", sort.toLowerCase());
		}
		if (sort_dir != null) {
			parameters.put("sort_dir", sort_dir.toLowerCase());
		}
		if (isHighlight()) {
			parameters.put("highlight", "1");
		}
	}

}
