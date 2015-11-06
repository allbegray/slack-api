package flowctrl.integration.slack.type;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamIntegrationLogList {

	protected List<IntegrationLog> logs;
	protected Paging paging;

	public List<IntegrationLog> getLogs() {
		if (logs == null) {
			logs = new ArrayList<IntegrationLog>();
		}
		return logs;
	}

	public void setLogs(List<IntegrationLog> logs) {
		this.logs = logs;
	}

	public Paging getPaging() {
		return paging;
	}

	public void setPaging(Paging paging) {
		this.paging = paging;
	}

	@Override
	public String toString() {
		return "TeamIntegrationLogList [logs=" + logs + ", paging=" + paging + "]";
	}

}
