package allbegray.slack.webapi.method.dnd;

import java.util.Map;

import allbegray.slack.SlackClientFactory;
import allbegray.slack.type.Authentication;
import allbegray.slack.type.EndSnooze;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import allbegray.slack.type.DndInfo;
import allbegray.slack.type.DndSimpleInfo;
import allbegray.slack.type.SetSnooze;
import allbegray.slack.webapi.SlackWebApiClient;

public class DndMethodTest {

	private String token = "your slack web api token";
	private String userToken = "install user token";
	private SlackWebApiClient webApiClient;

	@Before
	public void setup() {
		webApiClient = SlackClientFactory.createWebApiClient(token, userToken);
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
