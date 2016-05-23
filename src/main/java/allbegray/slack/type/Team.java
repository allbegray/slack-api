package allbegray.slack.type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Team {

	protected String id;
	protected String name;
	protected String doamin;
	protected String email_domain;
	protected Icon icon;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDoamin() {
		return doamin;
	}

	public void setDoamin(String doamin) {
		this.doamin = doamin;
	}

	public String getEmail_domain() {
		return email_domain;
	}

	public void setEmail_domain(String email_domain) {
		this.email_domain = email_domain;
	}

	public Icon getIcon() {
		return icon;
	}

	public void setIcon(Icon icon) {
		this.icon = icon;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name + ", doamin=" + doamin + ", email_domain=" + email_domain + "]";
	}

}
