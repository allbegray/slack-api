package flowctrl.integration.slack.type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DirectMessageChannel {

	protected String id;
	protected Boolean is_im;
	protected String user;
	protected Long created;
	protected Boolean is_user_deleted;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Boolean getIs_im() {
		return is_im;
	}

	public void setIs_im(Boolean is_im) {
		this.is_im = is_im;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Long getCreated() {
		return created;
	}

	public void setCreated(Long created) {
		this.created = created;
	}

	public Boolean getIs_user_deleted() {
		return is_user_deleted;
	}

	public void setIs_user_deleted(Boolean is_user_deleted) {
		this.is_user_deleted = is_user_deleted;
	}

	@Override
	public String toString() {
		return "Im [id=" + id + ", is_im=" + is_im + ", user=" + user + ", created=" + created + ", is_user_deleted=" + is_user_deleted + "]";
	}

}
