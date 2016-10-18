package allbegray.slack.rtm;

import com.fasterxml.jackson.databind.JsonNode;

public interface EventListener {
	
	public void onMessage(JsonNode message);
	
}
