package flowctrl.integration.slack.type;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Group {

	protected String id;
	protected String name;
	protected String is_group;
	protected Long created;
	protected String creator;
	protected Boolean is_archived;
	protected Boolean is_mpim;
	protected List<String> members;
	protected Topic topic;
	protected Purpose purpose;
	protected String last_read;
	protected int unread_count;
	protected int unread_count_display;

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

	public String getIs_group() {
		return is_group;
	}

	public void setIs_group(String is_group) {
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

	public Boolean getIs_archived() {
		return is_archived;
	}

	public void setIs_archived(Boolean is_archived) {
		this.is_archived = is_archived;
	}

	public Boolean getIs_mpim() {
		return is_mpim;
	}

	public void setIs_mpim(Boolean is_mpim) {
		this.is_mpim = is_mpim;
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

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public Purpose getPurpose() {
		return purpose;
	}

	public void setPurpose(Purpose purpose) {
		this.purpose = purpose;
	}

	public String getLast_read() {
		return last_read;
	}

	public void setLast_read(String last_read) {
		this.last_read = last_read;
	}

	public int getUnread_count() {
		return unread_count;
	}

	public void setUnread_count(int unread_count) {
		this.unread_count = unread_count;
	}

	public int getUnread_count_display() {
		return unread_count_display;
	}

	public void setUnread_count_display(int unread_count_display) {
		this.unread_count_display = unread_count_display;
	}

	@Override
	public String toString() {
		return "Group [id=" + id + ", name=" + name + ", is_group=" + is_group + ", created=" + created + ", creator=" + creator + ", is_archived=" + is_archived + ", is_mpim=" + is_mpim
				+ ", members=" + members + ", topic=" + topic + ", purpose=" + purpose + ", last_read=" + last_read + ", unread_count=" + unread_count + ", unread_count_display="
				+ unread_count_display + "]";
	}

}
