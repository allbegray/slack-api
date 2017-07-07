package allbegray.slack;

import java.io.File;
import java.util.List;
import java.util.Map;

import allbegray.slack.webapi.method.chats.ChatPostMessageMethod;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import allbegray.slack.type.Authentication;
import allbegray.slack.type.Channel;
import allbegray.slack.type.DirectMessageChannel;
import allbegray.slack.type.FileInfo;
import allbegray.slack.type.Group;
import allbegray.slack.type.History;
import allbegray.slack.type.Message;
import allbegray.slack.type.PinItem;
import allbegray.slack.type.Presence;
import allbegray.slack.type.ReactionList;
import allbegray.slack.type.StarList;
import allbegray.slack.type.Team;
import allbegray.slack.type.TeamAccessLogList;
import allbegray.slack.type.User;
import allbegray.slack.type.UserPresence;
import allbegray.slack.webapi.SlackWebApiClient;
import wiremock.org.apache.commons.lang3.RandomStringUtils;

public class SlackWebApiClientTest {

	private String token = "your slack web api token";
	private SlackWebApiClient webApiClient;
	private File testfile;

	@Before
	public void setup() {
		webApiClient = SlackClientFactory.createWebApiClient(token);
		testfile = new File("d:\\2.jpg");
	}
	
	@After
	public void shutdown() {
		webApiClient.shutdown();
	}

	@Test
	public void MultipartyDirectMessageChannelTest() {
		String user1 = "userId1";
		String user2 = "userId2";
		Group group = webApiClient.openMultipartyDirectMessageChannel(user1, user2);

		List<Group> messageChannels = webApiClient.getMultipartyDirectMessageChannelList();
		Assert.assertTrue(messageChannels.size() > 0);

		History history = webApiClient.getMultipartyDirectMessageChannelHistory(group.getId());
		Assert.assertTrue(history.getHas_more() != null);

		webApiClient.closeMultipartyDirectMessageChannel(group.getId());
	}

	@Test
	public void directMessageChannelTest() {
		List<DirectMessageChannel> messageChannels = webApiClient.getDirectMessageChannelList();

		DirectMessageChannel slackbot = null;
		for (DirectMessageChannel channel : messageChannels) {
			if (channel.getUser().contains("SLACKBOT")) {
				slackbot = channel;
				break;
			}
		}
		webApiClient.closeDirectMessageChannel(slackbot.getId());

		String channel = webApiClient.openDirectMessageChannel(slackbot.getUser());
		Assert.assertTrue(channel != null);
		
		History history = webApiClient.getDirectMessageChannelHistory(slackbot.getId());
		Assert.assertTrue(history.getMessages().size() > 0);
	}

	@Test
	public void userTest() {
		webApiClient.setPresenceUser(Presence.AUTO);
		webApiClient.setActiveUser();

		List<User> users = webApiClient.getUserList();
		User user = users.get(0);
		user = webApiClient.getUserInfo(user.getId());

		UserPresence userPresence = webApiClient.getUserPresence(user.getId());
		Assert.assertTrue(userPresence.getPresence() != null);
	}

	@Test
	public void basicTest() {
		Authentication authentication = webApiClient.auth();
		String user = authentication.getUser();
		String userId = authentication.getUser_id();

		Assert.assertTrue(user != null);
		Assert.assertTrue(userId != null);

		TeamAccessLogList teamAccessLogList = null;
		try {
			teamAccessLogList = webApiClient.getTeamAccessLogList(1);
			Assert.assertTrue(teamAccessLogList.getLogins().size() > 0);
		} catch (Exception e) {
			Assert.assertTrue(e.getMessage().startsWith("paid_only"));
		}

		Team team = webApiClient.getTeamInfo();
		Assert.assertTrue(team.getId() != null);


		String channelName = "test_channel_" + RandomStringUtils.randomAlphabetic(5).toLowerCase();
		Channel channel = webApiClient.createChannel(channelName);
		String channelId = channel.getId();

		Assert.assertTrue(channel.getId() != null);
		Assert.assertTrue(channel.getName() != null);
		Assert.assertTrue(channel.getCreated() != null);
		Assert.assertTrue(channel.getCreator() != null);
		Assert.assertTrue(channel.getCreator() != null);
		Assert.assertTrue(channel.getIs_archived() != null);
		Assert.assertTrue(channel.getIs_member() != null);
		Assert.assertTrue(channel.getIs_general() != null);
		Assert.assertTrue(channel.getLast_read() != null);
		Assert.assertTrue(channel.getUnread_count() != null);
		Assert.assertTrue(channel.getUnread_count_display() != null);
		Assert.assertTrue(channel.getMembers().size() > 0);

		channel = webApiClient.getChannelInfo(channelId);
		Assert.assertTrue(channel.getId() != null);
		channelId = channel.getId();

		String newChannelName = RandomStringUtils.randomAlphabetic(5).toLowerCase() + "_changed_test_channel";
		channel = webApiClient.renameChannel(channelId, newChannelName);
		Assert.assertTrue(channel.getId() != null);
		channelId = channel.getId();

		boolean purpose = webApiClient.setChannelPurpose(channelId, "test purpose");
		boolean topic = webApiClient.setChannelTopic(channelId, "test topic");
		Assert.assertTrue(purpose);
		Assert.assertTrue(topic);

		Map<String, String> emojis = webApiClient.getEmojiList();
		Assert.assertTrue(emojis.size() > 0);

		ChatPostMessageMethod postMessage = new ChatPostMessageMethod(channelId, "test message");
		postMessage.setUnfurl_links(true);
		postMessage.setUnfurl_media(true);
		postMessage.setAs_user(true);
		postMessage.setIcon_emoji("bowtie");
		postMessage.setIcon_url(emojis.get("bowtie"));
		postMessage.setUsername(user);
		String ts = webApiClient.postMessage(postMessage);
		Assert.assertTrue(ts != null);

		// threaded message
		ChatPostMessageMethod answerMessage = new ChatPostMessageMethod(channelId, "test answer");
		answerMessage.setThread_ts(ts);
		String tsAnswer = webApiClient.postMessage(answerMessage);

		webApiClient.addStarToMessage(channelId, ts);
		webApiClient.addReactionToMessage("squirrel", channelId, ts);
		webApiClient.pinMessage(channelId, ts);

		String ts2 = webApiClient.postMessage(channelId, "test message");
		Assert.assertTrue(ts2 != null);

		if (testfile != null && testfile.exists()) {
			allbegray.slack.type.File slackFile = webApiClient.uploadFile(testfile, "test file", "test comment", channelId);
			String fileId = slackFile.getId();

			FileInfo fileInfo = webApiClient.getFileInfo(fileId);
			fileId = fileInfo.getFile().getId();

			webApiClient.addStarToFile(fileId);
			webApiClient.addReactionToFile("squirrel", fileId);
			webApiClient.pinFile(channelId, fileId);

			webApiClient.removeStarFromFile(fileId);
			webApiClient.removeReactionFromFile("squirrel", fileId);
			webApiClient.unpinFile(channelId, fileId);
		}

		List<PinItem> pinItems = webApiClient.getPinList(channelId);
		Assert.assertTrue(pinItems.size() > 0);

		ReactionList reactionList = webApiClient.getReactionList(1);
		Assert.assertTrue(reactionList.getItems().size() > 0);

		StarList starList = webApiClient.getStarList(1);
		Assert.assertTrue(starList.getItems().size() > 0);

		boolean is_archive = webApiClient.archiveChannel(channelId);
		boolean is_unarchive = webApiClient.unarchiveChannel(channelId);
		Assert.assertTrue(is_archive);
		Assert.assertTrue(is_unarchive);

		History history = webApiClient.getChannelHistory(channelId);
		Assert.assertTrue(history.getMessages().size() > 0);

		Message message = history.getMessages().get(0);
		Assert.assertTrue(message.getType() != null);
		Assert.assertTrue(message.getTs() != null);

		Message answer = history.getMessages().stream().filter(mess -> mess.getTs().equals(tsAnswer)).findFirst().get();
		Assert.assertEquals(ts, answer.getThread_ts());
	}

	@Test
	public void shouldReturnTheDefaultApiUrlIfNotExplicitlySet() {
		Assert.assertEquals("https://slack.com/api", webApiClient.getWebApiUrl());
	}

	@Test
	public void shouldReturnNonDefaultApiUrlIfExplicitlySet() {
		webApiClient.setWebApiUrl("http://localhost:8080");
		Assert.assertEquals("http://localhost:8080", webApiClient.getWebApiUrl());
	}

}
