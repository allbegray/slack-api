package flowctrl.integration.slack.type;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MultipartyDirectMessage {

	protected String id;
	protected String name;
	protected Boolean is_mpim;
	protected Boolean is_group;
	protected Long created;
	protected String creator;
	protected List<String> members;
	protected String last_read;
	protected Integer unread_count;
	protected Integer unread_count_display;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getIs_mpim() {
		return is_mpim;
	}

	public void setIs_mpim(Boolean is_mpim) {
		this.is_mpim = is_mpim;
	}

	public Boolean getIs_group() {
		return is_group;
	}

	public void setIs_group(Boolean is_group) {
		this.is_group = is_group;
	}

	public Long getCreated() {
		return created;
	}

	public void setCreated(Long created) {
		this.created = created;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public List<String> getMembers() {
		if (members == null) {
			members = new ArrayList<String>();
		}
		return members;
	}

	public void setMembers(List<String> members) {
		this.members = members;
	}

	public String getLast_read() {
		return last_read;
	}

	public void setLast_read(String last_read) {
		this.last_read = last_read;
	}

	public Integer getUnread_count() {
		return unread_count;
	}

	public void setUnread_count(Integer unread_count) {
		this.unread_count = unread_count;
	}

	public Integer getUnread_count_display() {
		return unread_count_display;
	}

	public void setUnread_count_display(Integer unread_count_display) {
		this.unread_count_display = unread_count_display;
	}

	@Override
	public String toString() {
		return "Mpim [id=" + id + ", name=" + name + ", is_mpim=" + is_mpim + ", is_group=" + is_group + ", created=" + created + ", creator=" + creator + ", members=" + members + ", last_read="
				+ last_read + ", unread_count=" + unread_count + ", unread_count_display=" + unread_count_display + "]";
	}

}