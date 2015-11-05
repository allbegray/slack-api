package flowctrl.integration.slack.type;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamAccessLogList {

	protected List<AccessLog> logins;
	protected Paging paging;

	public List<AccessLog> getLogins() {
		if (logins == null) {
			logins = new ArrayList<AccessLog>();
		}
		return logins;
	}

	public void setLogins(List<AccessLog> logins) {
		this.logins = logins;
	}

	public Paging getPaging() {
		return paging;
	}

	public void setPaging(Paging paging) {
		this.paging = paging;
	}

	@Override
	public String toString() {
		return "TeamAccessLog [logins=" + logins + ", paging=" + paging + "]";
	}

}
