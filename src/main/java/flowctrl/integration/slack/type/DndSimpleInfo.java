package flowctrl.integration.slack.type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DndSimpleInfo {

	private Boolean dnd_enabled;
	private Long next_dnd_start_ts;
	private Long next_dnd_end_ts;

	public Boolean getDnd_enabled() {
		return dnd_enabled;
	}

	public void setDnd_enabled(Boolean dnd_enabled) {
		this.dnd_enabled = dnd_enabled;
	}

	public Long getNext_dnd_start_ts() {
		return next_dnd_start_ts;
	}

	public void setNext_dnd_start_ts(Long next_dnd_start_ts) {
		this.next_dnd_start_ts = next_dnd_start_ts;
	}

	public Long getNext_dnd_end_ts() {
		return next_dnd_end_ts;
	}

	public void setNext_dnd_end_ts(Long next_dnd_end_ts) {
		this.next_dnd_end_ts = next_dnd_end_ts;
	}

}
