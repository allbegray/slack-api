package allbegray.slack.type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DndInfo extends DndSimpleInfo {

	private Boolean snooze_enabled;
	private Long snooze_endtime;
	private Long snooze_remaining;

	public Boolean getSnooze_enabled() {
		return snooze_enabled;
	}

	public void setSnooze_enabled(Boolean snooze_enabled) {
		this.snooze_enabled = snooze_enabled;
	}

	public Long getSnooze_endtime() {
		return snooze_endtime;
	}

	public void setSnooze_endtime(Long snooze_endtime) {
		this.snooze_endtime = snooze_endtime;
	}

	public Long getSnooze_remaining() {
		return snooze_remaining;
	}

	public void setSnooze_remaining(Long snooze_remaining) {
		this.snooze_remaining = snooze_remaining;
	}

}
