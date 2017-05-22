package allbegray.slack.webapi.api;

import com.fasterxml.jackson.databind.JsonNode;

public interface RtmApi {

    JsonNode startRealTimeMessagingApi();

    JsonNode startRealTimeMessagingApi(String simple_latest, String no_unreads, String mpim_aware);
}
