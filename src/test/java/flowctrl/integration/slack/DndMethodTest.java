package flowctrl.integration.slack;

import java.util.Map;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import flowctrl.integration.slack.type.Authentication;
import flowctrl.integration.slack.type.DndInfo;
import flowctrl.integration.slack.type.DndSimpleInfo;
import flowctrl.integration.slack.type.EndSnooze;
import flowctrl.integration.slack.type.SetSnooze;
import flowctrl.integration.slack.webapi.SlackWebApiClient;

public class DndMethodTest {

	private String token = "your slack web api token";
	private SlackWebApiClient webApiClient;

	@Before
	public void setup() {
		webApiClient = SlackClientFactory.createWebApiClient(token);
	}

	@After
	public void shutdown() {
		webApiClient.shutdown();
	}

	@Test
	public void basicTest() {
		Authentication authentication = webApiClient.auth();

		Map<String, DndSimpleInfo> dndTeamInfo = webApiClient.getDndTeamInfo();
		Assert.assertTrue(dndTeamInfo.size() > 0);

		DndInfo dndInfo = webApiClient.getDndInfo(authentication.getUser_id());
		Assert.assertTrue(dndInfo.getSnooze_enabled() != null);

		boolean isEndDnd = webApiClient.endDnd();
		Assert.assertTrue(isEndDnd == true);

		SetSnooze setSnooze = webApiClient.setSnooze(1);
		Assert.assertTrue(setSnooze.getSnooze_enabled() == true);

		EndSnooze endSnooze = webApiClient.endSnooze();
		Assert.assertTrue(endSnooze.getSnooze_enabled() == false);

		isEndDnd = webApiClient.endDnd();
		Assert.assertTrue(isEndDnd == true);
	}

}
