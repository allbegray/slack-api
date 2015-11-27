package flowctrl.integration.slack.type;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Usergroup {

	protected String id;
	protected String team_id;
	protected Boolean is_usergroup;
	protected String name;
	protected String description;
	protected String handle;
	protected Boolean is_external;
	protected Long date_create;
	protected Long date_update;
	protected Long date_delete;
	protected String auto_type;
	protected String created_by;
	protected String updated_by;
	protected String deleted_by;
	// protected String prefs;
	protected List<String> users;
	protected Integer user_count;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTeam_id() {
		return team_id;
	}

	public void setTeam_id(String team_id) {
		this.team_id = team_id;
	}

	public Boolean getIs_usergroup() {
		return is_usergroup;
	}

	public void setIs_usergroup(Boolean is_usergroup) {
		this.is_usergroup = is_usergroup;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHandle() {
		return handle;
	}

	public void setHandle(String handle) {
		this.handle = handle;
	}

	public Boolean getIs_external() {
		return is_external;
	}

	public void setIs_external(Boolean is_external) {
		this.is_external = is_external;
	}

	public Long getDate_create() {
		return date_create;
	}

	public void setDate_create(Long date_create) {
		this.date_create = date_create;
	}

	public Long getDate_update() {
		return date_update;
	}

	public void setDate_update(Long date_update) {
		this.date_update = date_update;
	}

	public Long getDate_delete() {
		return date_delete;
	}

	public void setDate_delete(Long date_delete) {
		this.date_delete = date_delete;
	}

	public String getAuto_type() {
		return auto_type;
	}

	public void setAuto_type(String auto_type) {
		this.auto_type = auto_type;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public String getUpdated_by() {
		return updated_by;
	}

	public void setUpdated_by(String updated_by) {
		this.updated_by = updated_by;
	}

	public String getDeleted_by() {
		return deleted_by;
	}

	public void setDeleted_by(String deleted_by) {
		this.deleted_by = deleted_by;
	}

	public List<String> getUsers() {
		return users;
	}

	public void setUsers(List<String> users) {
		this.users = users;
	}

	public Integer getUser_count() {
		return user_count;
	}

	public void setUser_count(Integer user_count) {
		this.user_count = user_count;
	}

	@Override
	public String toString() {
		return "Usergroup [id=" + id + ", team_id=" + team_id + ", is_usergroup=" + is_usergroup + ", name=" + name + ", description=" + description + ", handle=" + handle + ", is_external="
				+ is_external + ", date_create=" + date_create + ", date_update=" + date_update + ", date_delete=" + date_delete + ", auto_type=" + auto_type + ", created_by=" + created_by
				+ ", updated_by=" + updated_by + ", deleted_by=" + deleted_by + ", users=" + users + ", user_count=" + user_count + "]";
	}

}
