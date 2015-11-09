package flowctrl.integration.slack.rtm;

public class ProxyServerInfo {

	protected String protocol;
	protected String host;
	protected int port;

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

	@Override
	public String toString() {
		return "ProxyServerInfo [protocol=" + protocol + ", host=" + host + ", port=" + port + "]";
	}

}
