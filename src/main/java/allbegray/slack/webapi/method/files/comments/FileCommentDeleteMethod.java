package allbegray.slack.webapi.method.files.comments;

import java.util.List;
import java.util.Map;

import allbegray.slack.validation.Problem;
import allbegray.slack.validation.ValidationError;
import allbegray.slack.webapi.SlackWebApiConstants;
import allbegray.slack.webapi.method.AbstractMethod;

public class FileCommentDeleteMethod extends AbstractMethod {

	private String file;
	private String id;

	public FileCommentDeleteMethod(String file, String id) {
		this.file = file;
		this.id = id;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.FILES_COMMENTS_DELETE;
	}

	@Override
	public void validate(List<ValidationError> errors) {
		if (file == null) {
			addError(errors, "file", Problem.REQUIRED);
		}
		if (id == null) {
			addError(errors, "id", Problem.REQUIRED);
		}
	}

	@Override
	protected void createParameters(Map<String, String> parameters) {
		parameters.put("file", file);
		parameters.put("id", id);
	}

}
