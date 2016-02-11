package flowctrl.integration.slack.webapi.method.files.comments;

import java.util.List;
import java.util.Map;

import flowctrl.integration.slack.validation.Problem;
import flowctrl.integration.slack.validation.ValidationError;
import flowctrl.integration.slack.webapi.SlackWebApiConstants;
import flowctrl.integration.slack.webapi.method.AbstractMethod;

public class FileCommentEditMethod extends AbstractMethod {

	private String file;
	private String id;
	private String comment;

	public FileCommentEditMethod(String file, String id, String comment) {
		this.file = file;
		this.id = id;
		this.comment = comment;
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.FILES_COMMENTS_EDIT;
	}

	@Override
	public void validate(List<ValidationError> errors) {
		if (file == null) {
			addError(errors, "file", Problem.REQUIRED);
		}
		if (id == null) {
			addError(errors, "id", Problem.REQUIRED);
		}
		if (comment == null) {
			addError(errors, "comment", Problem.REQUIRED);
		}
	}

	@Override
	protected void createParameters(Map<String, String> parameters) {
		parameters.put("file", file);
		parameters.put("id", id);
		parameters.put("comment", comment);
	}

}
