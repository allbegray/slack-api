package allbegray.slack.type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Purpose {

	protected String value;
	protected String creator;
	protected Integer last_set;

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Integer getLast_set() {
		return last_set;
	}

	public void setLast_set(Integer last_set) {
		this.last_set = last_set;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Purpose [value=" + value + ", creator=" + creator + ", last_set=" + last_set + "]";
	}

}
