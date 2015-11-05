package flowctrl.integration.slack.type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserPresence {

	protected String presence;
	protected Boolean online;
	protected Boolean auto_away;
	protected Boolean manual_away;
	protected Long connection_count;
	protected Long last_activity;

	public String getPresence() {
		return presence;
	}

	public void setPresence(String presence) {
		this.presence = presence;
	}

	public Boolean getOnline() {
		return online;
	}

	public void setOnline(Boolean online) {
		this.online = online;
	}

	public Boolean getAuto_away() {
		return auto_away;
	}

	public void setAuto_away(Boolean auto_away) {
		this.auto_away = auto_away;
	}

	public Boolean getManual_away() {
		return manual_away;
	}

	public void setManual_away(Boolean manual_away) {
		this.manual_away = manual_away;
	}

	public Long getConnection_count() {
		return connection_count;
	}

	public void setConnection_count(Long connection_count) {
		this.connection_count = connection_count;
	}

	public Long getLast_activity() {
		return last_activity;
	}

	public void setLast_activity(Long last_activity) {
		this.last_activity = last_activity;
	}

	@Override
	public String toString() {
		return "UserPresence [presence=" + presence + ", online=" + online + ", auto_away=" + auto_away + ", manual_away=" + manual_away + ", connection_count=" + connection_count + ", last_activity="
				+ last_activity + "]";
	}

}
