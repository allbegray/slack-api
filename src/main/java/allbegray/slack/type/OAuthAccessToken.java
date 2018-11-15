package allbegray.slack.type;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OAuthAccessToken {

	protected String access_token;
	protected String scope;
	protected String team_id;
	protected String team_name;
	protected BotAccessToken bot;

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public Set<String> getScopes() {
		if (scope == null) {
			return Collections.emptySet();
		}
		return new HashSet<String>(Arrays.asList(scope.split(",")));
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getTeam_id() {
		return team_id;
	}

	public void setTeam_id(String team_id) {
		this.team_id = team_id;
	}

	public String getTeam_name() {
		return team_name;
	}

	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}

	public BotAccessToken getBot() {
		return bot;
	}

	public void setBot(BotAccessToken bot) {
		this.bot = bot;
	}

	@Override
	public String toString() {
		return "OAuthAccessToken [access_token=" + access_token + ", scope=" + scope + ", team_id=" + team_id +
				", team_name=" + team_name + ", bot=" + bot + "]";
	}

}
