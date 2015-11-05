package flowctrl.integration.slack.type;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FileList {

	protected List<File> files;
	protected Paging paging;

	public List<File> getFiles() {
		if (files == null) {
			files = new ArrayList<File>();
		}
		return files;
	}

	public void setFiles(List<File> files) {
		this.files = files;
	}

	public Paging getPaging() {
		return paging;
	}

	public void setPaging(Paging paging) {
		this.paging = paging;
	}

	@Override
	public String toString() {
		return "FileList [files=" + files + ", paging=" + paging + "]";
	}

}
