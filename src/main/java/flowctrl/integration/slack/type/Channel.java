package flowctrl.integration.slack.type;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Channel {

	protected String id;
	protected String name;
	protected String is_channel;
	protected Long created;
	protected String creator;
	protected Boolean is_archived;
	protected Boolean is_general;
	protected Boolean is_member;
	protected List<String> members;
	protected Topic topic;
	protected Purpose purpose;
	protected String last_read;
	protected Integer unread_count;
	protected Integer unread_count_display;
	protected Message latest;
	
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

	public String getIs_channel() {
		return is_channel;
	}

	public void setIs_channel(String is_channel) {
		this.is_channel = is_channel;
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

	public Boolean getIs_general() {
		return is_general;
	}

	public void setIs_general(Boolean is_general) {
		this.is_general = is_general;
	}

	public Boolean getIs_member() {
		return is_member;
	}

	public void setIs_member(Boolean is_member) {
		this.is_member = is_member;
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

	public Message getLatest() {
		return latest;
	}
	
	@Override
	public String toString() {
		return "Channel [id=" + id + ", name=" + name + ", is_channel=" + is_channel + ", created=" + created + ", creator=" + creator + ", is_archived=" + is_archived + ", is_general=" + is_general
				+ ", is_member=" + is_member + ", members=" + members + ", topic=" + topic + ", purpose=" + purpose + ", last_read=" + last_read + ", unread_count=" + unread_count
				+ ", unread_count_display=" + unread_count_display + "]";
	}

}
