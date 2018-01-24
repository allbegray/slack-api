package allbegray.slack.type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

	protected String id;
	protected String name;
	protected String tz;
	protected Boolean deleted;
	protected String color;
	protected Profile profile;
	protected Boolean is_admin;
	protected Boolean is_owner;
	protected Boolean is_primary_owner;
	protected Boolean is_restricted;
	protected Boolean is_ultra_restricted;
	protected Boolean has_2fa;
	protected String two_factor_type;
	protected Boolean has_files;

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

	public String getTz() {
		return tz;
	}

	public void setTz(String tz) {
		this.tz = tz;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public Boolean getIs_admin() {
		return is_admin;
	}

	public void setIs_admin(Boolean is_admin) {
		this.is_admin = is_admin;
	}

	public Boolean getIs_owner() {
		return is_owner;
	}

	public void setIs_owner(Boolean is_owner) {
		this.is_owner = is_owner;
	}

	public Boolean getIs_primary_owner() {
		return is_primary_owner;
	}

	public void setIs_primary_owner(Boolean is_primary_owner) {
		this.is_primary_owner = is_primary_owner;
	}

	public Boolean getIs_restricted() {
		return is_restricted;
	}

	public void setIs_restricted(Boolean is_restricted) {
		this.is_restricted = is_restricted;
	}

	public Boolean getIs_ultra_restricted() {
		return is_ultra_restricted;
	}

	public void setIs_ultra_restricted(Boolean is_ultra_restricted) {
		this.is_ultra_restricted = is_ultra_restricted;
	}

	public Boolean getHas_2fa() {
		return has_2fa;
	}

	public void setHas_2fa(Boolean has_2fa) {
		this.has_2fa = has_2fa;
	}

	public String getTwo_factor_type() {
		return two_factor_type;
	}

	public void setTwo_factor_type(String two_factor_type) {
		this.two_factor_type = two_factor_type;
	}

	public Boolean getHas_files() {
		return has_files;
	}

	public void setHas_files(Boolean has_files) {
		this.has_files = has_files;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", tz=" + tz + ", deleted=" + deleted + ", color=" + color + ", profile="
				+ profile + ", is_admin=" + is_admin + ", is_owner=" + is_owner + ", is_primary_owner="
				+ is_primary_owner + ", is_restricted=" + is_restricted + ", is_ultra_restricted=" + is_ultra_restricted
				+ ", has_2fa=" + has_2fa + ", two_factor_type=" + two_factor_type + ", has_files=" + has_files + "]";
	}

}
