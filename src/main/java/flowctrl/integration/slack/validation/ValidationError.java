package flowctrl.integration.slack.validation;

public class ValidationError {

	public ValidationError() {
	}

	public ValidationError(String field, Problem problem, String description) {
		this.field = field;
		this.problem = problem;
		this.description = description;
	}

	protected String field;
	protected Problem problem;
	protected String description;

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public Problem getProblem() {
		return problem;
	}

	public void setProblem(Problem problem) {
		this.problem = problem;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
