package allbegray.slack.webapi.method.files;

import java.util.List;
import java.util.Map;

import allbegray.slack.validation.ValidationError;
import allbegray.slack.webapi.SlackWebApiConstants;
import allbegray.slack.webapi.method.AbstractMethod;

public class FileUploadMethod extends AbstractMethod {

	protected String filetype;
	protected String filename;
	protected String title;
	protected String initial_comment;
	protected String channels;

	public String getFiletype() {
		return filetype;
	}

	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getInitial_comment() {
		return initial_comment;
	}

	public void setInitial_comment(String initial_comment) {
		this.initial_comment = initial_comment;
	}

	public String getChannels() {
		return channels;
	}

	public void setChannels(String channels) {
		this.channels = channels;
	}

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.FILES_UPLOAD;
	}

	@Override
	public void validate(List<ValidationError> errors) {
		// ignore
	}

	@Override
	protected void createParameters(Map<String, String> parameters) {
		if (filetype != null) {
			parameters.put("filetype", filetype);
		}
		if (filename != null) {
			parameters.put("filename", filename);
		}
		if (title != null) {
			parameters.put("title", title);
		}
		if (initial_comment != null) {
			parameters.put("initial_comment", initial_comment);
		}
		if (channels != null) {
			parameters.put("channels", channels);
		}
	}

}
