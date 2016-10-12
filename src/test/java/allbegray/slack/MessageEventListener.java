package allbegray.slack;

import allbegray.slack.rtm.EventListener;
import com.fasterxml.jackson.databind.JsonNode;

public class MessageEventListener implements EventListener {

	@Override
	public void onMessage(JsonNode message) {
		System.out.println(message);
	}

}
