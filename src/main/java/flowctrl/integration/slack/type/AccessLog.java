package flowctrl.integration.slack.type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AccessLog {
	
	protected String user_id;
	protected String username;
	protected Long date_first;
	protected Long date_last;
	protected Integer count;
	protected String ip;
	protected String user_agent;
	protected String isp;
	protected String country;
	protected String region;

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getDate_first() {
		return date_first;
	}

	public void setDate_first(Long date_first) {
		this.date_first = date_first;
	}

	public Long getDate_last() {
		return date_last;
	}

	public void setDate_last(Long date_last) {
		this.date_last = date_last;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getUser_agent() {
		return user_agent;
	}

	public void setUser_agent(String user_agent) {
		this.user_agent = user_agent;
	}

	public String getIsp() {
		return isp;
	}

	public void setIsp(String isp) {
		this.isp = isp;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	@Override
	public String toString() {
		return "AccessLog [user_id=" + user_id + ", username=" + username + ", date_first=" + date_first + ", date_last=" + date_last + ", count=" + count + ", ip=" + ip + ", user_agent=" + user_agent
				+ ", isp=" + isp + ", country=" + country + ", region=" + region + "]";
	}

}
