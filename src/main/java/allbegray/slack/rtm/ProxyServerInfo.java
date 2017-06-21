package allbegray.slack.rtm;

public class ProxyServerInfo {

	protected String protocol;
	protected String host;
	protected int port;
	protected String principal;
	protected String password;

	public ProxyServerInfo() {
	}

	public ProxyServerInfo(String host, int port) {
		this.host = host;
		this.port = port;
	}

	public ProxyServerInfo(String protocol, String host, int port) {
		this.protocol = protocol;
		this.host = host;
		this.port = port;
	}

	public ProxyServerInfo(String protocol, String host, int port, String principal, String password) {
		this.protocol = protocol;
		this.host = host;
		this.port = port;
		this.principal = principal;
		this.password = password;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "ProxyServerInfo [protocol=" + protocol + ", host=" + host + ", port=" + port + "]";
	}

}
