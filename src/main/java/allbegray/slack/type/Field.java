package allbegray.slack.type;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
public class Field {

	protected String title;
	protected String value;
	
	@JsonProperty("short")
	protected Boolean _short;

	public Field() {
	}

	public Field(String title, String value) {
		this.title = title;
		this.value = value;
	}

	public Field(String title, String value, Boolean _short) {
		this.title = title;
		this.value = value;
		this._short = _short;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Boolean get_short() {
		return _short;
	}

	public void set_short(Boolean _short) {
		this._short = _short;
	}

	@Override
	public String toString() {
		return "Field [title=" + title + ", value=" + value + ", short=" + _short + "]";
	}

}
