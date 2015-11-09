package flowctrl.integration.slack.rtm;

import com.fasterxml.jackson.databind.JsonNode;

public interface EventListener {
	
	public void handleMessage(JsonNode message);
	
}
