package allbegray.slack.type;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DndTeamInfoTest {

	@Test
	public void deserializeTest() throws JsonProcessingException, IOException {

		StringBuffer json = new StringBuffer();
		json.append(" {                                              ");
		json.append("     \"ok\": true,                              ");
		json.append("     \"users\": {                               ");
		json.append("         \"U07GVSQ2Z\": {                       ");
		json.append("             \"dnd_enabled\": true,             ");
		json.append("             \"next_dnd_start_ts\": 1455195600, ");
		json.append("             \"next_dnd_end_ts\": 1455231600    ");
		json.append("         },                                     ");
		json.append("         \"U08AHNL0H\": {                       ");
		json.append("             \"dnd_enabled\": true,             ");
		json.append("             \"next_dnd_start_ts\": 1455195600, ");
		json.append("             \"next_dnd_end_ts\": 1455231600    ");
		json.append("         }                                      ");
		json.append("     }                                          ");
		json.append(" }                                              ");

		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode = objectMapper.readTree(json.toString());
		jsonNode = jsonNode.findPath("users");

		Map<String, DndSimpleInfo> maps = objectMapper.readValue(jsonNode.toString(), new TypeReference<Map<String, DndSimpleInfo>>() {
		});

		for (Entry<String, DndSimpleInfo> entry : maps.entrySet()) {
			System.out.println(entry.getKey());
			DndSimpleInfo dndSimpleInfo = entry.getValue();
			System.out.print("dnd_enabled : " + dndSimpleInfo.getDnd_enabled());
			System.out.print(" next_dnd_start_ts : " + dndSimpleInfo.getNext_dnd_start_ts());
			System.out.println(" next_dnd_end_ts : " + dndSimpleInfo.getNext_dnd_end_ts());
		}

	}
}
