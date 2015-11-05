slack-api
=============
A Java client for the Web APIs, Incoming Webhooks, Slackbot

## Slack client factory
```java

SlackWebApiClient webApiClient = SlackClientFactory.createWebApiClient(token);

SlackWebhookClient webhookClient = SlackClientFactory.createWebhookClient(webhookUrl);

SlackbotClient slackbotClient = SlackClientFactory.createSlackbotClient(slackbotUrl);

```

## Example
```java

public class SlackWebApiClientTest {

	private String token = "your slack web api token";
	private SlackWebApiClient webApiClient;
	private File testfile;

	@Before
	public void setup() {
		webApiClient = SlackClientFactory.createWebApiClient(token);
		testfile = new File("d:\\2.jpg");
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

		webApiClient.openDirectMessageChannel(slackbot.getUser());

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
			Assert.assertTrue(e.getMessage().equals("paid_only"));
		}

		Team team = webApiClient.getTeamInfo();
		Assert.assertTrue(team.getId() != null);

		Channel channel = webApiClient.createChannel("test_channel");
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

		channel = webApiClient.renameChannel(channelId, "changed_test_channel");
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

		webApiClient.addStarToMessage(channelId, ts);
		webApiClient.addReactionToMessage("squirrel", channelId, ts);
		webApiClient.pinMessage(channelId, ts);

		String ts2 = webApiClient.postMessage(channelId, "test message");
		Assert.assertTrue(ts2 != null);

		if (testfile != null && testfile.exists()) {
			flowctrl.integration.slack.type.File slackFile = webApiClient.uploadFile(testfile, "test file", "test comment", channelId);
			String fileId = slackFile.getId();

			FileInfo fileInfo = webApiClient.getFileInfo(fileId);
			fileId = fileInfo.getFile().getId();

			webApiClient.addStarToFile(fileId);
			webApiClient.addReactionToFile("squirrel", fileId);
			webApiClient.pinFile(channelId, fileId);

			webApiClient.removeStarToFile(fileId);
			webApiClient.removeReactionToFile("squirrel", fileId);
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
	}

}



public class SlackWebhookClientTest {

	private String webhookUrl = "https://hooks.slack.com/services/{id_1}/{id_2}/{token}";
	private SlackWebhookClient webhookClient;

	@Before
	public void setup() {
		webhookClient = SlackClientFactory.createWebhookClient(webhookUrl);
	}

	@Test
	public void basicTest() {
		
		Payload payload = new Payload();
		payload.setText("test text");
		payload.setChannel("#general");
		payload.setUsername("send user");
		payload.setIcon_emoji(":octocat:");

		Attachment attachment = new Attachment();
		attachment.setTitle("test attachment title");
		attachment.setColor("good");
		attachment.setText("test attachment text");
		attachment.addField(new Field("test field title 1", "test field value 1"));
		attachment.addField(new Field("test field title 2", "test field value 2"));
		payload.addAttachment(attachment);

		webhookClient.post(payload);
		
	}

}



public class SlackbotClientTest {

	private String slackbotUrl = "https://{yourteam}.slack.com/services/hooks/slackbot?token={token}";
	private SlackbotClient slackbotClient;

	@Before
	public void setup() {
		slackbotClient = SlackClientFactory.createSlackbotClient(slackbotUrl);
	}

	@Test
	public void basicTest() {
		slackbotClient.post("#channelName", "test message 1");
		slackbotClient.post("@userName", "test message 2");
	}

}

```

### Slack API compatibility
auth, channels, chat, emoji, files, groups, im, mpim, pins, reactions, stars, team, users

### Coming soon next
search, oauth, rtm Api
