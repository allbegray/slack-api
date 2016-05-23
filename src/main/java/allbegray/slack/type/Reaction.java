package allbegray.slack.type;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Reaction {

	protected String name;
	protected Integer count;
	protected List<String> users;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public List<String> getUsers() {
		if (users == null) {
			users = new ArrayList<String>();
		}
		return users;
	}

	public void setUsers(List<String> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Reaction [name=" + name + ", count=" + count + ", users=" + users + "]";
	}

}
