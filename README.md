[![Release](https://img.shields.io/github/release/flowctrl/slack-api.svg?label=JitPack)](https://jitpack.io/#flowctrl/slack-api)

slack-api
=============
A Java client for the Web APIs, Incoming Webhooks, Slackbot, RTM(Real Time Messaging)

## Change Logs

### v1.0.7.RELEASE

[fix #1 - Channel name reg expression](https://github.com/flowctrl/slack-api/issues/1)

### v1.0.6.RELEASE

using PoolingHttpClientConnectionManager

### v1.0.5.RELEASE

add RTM(Real Time Messaging) Client (https://api.slack.com/rtm)
```java
public class SlackRealTimeMessagingClientTest {

	private String token = "your slack web api token";

	@Test
	public void basicTest() {
		SlackRealTimeMessagingClient realTimeMessagingClient = SlackClientFactory.createSlackRealTimeMessagingClient(token);
		realTimeMessagingClient.addListener("hello", new HelloEventListener());
		realTimeMessagingClient.addListener("message", new MessageEventListener());
		realTimeMessagingClient.addListener(Event.MESSAGE, new EventListener() {
			@Override
			public void handleMessage(JsonNode message) {
				// todo
			}
		});
		realTimeMessagingClient.connect();
		
		try {
			Thread.sleep(60 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
}
```

add "rtm.start" method (https://api.slack.com/methods/rtm.start)

add SlackTextBuilder
```java
String message = SlackTextBuilder.create()
	.text("text message")
	.link("https://slack.com/")
	.link("https://slack.com", "Slack")
	.bold("bold message")
	.italic("italic message")
	.strike("strike message")
	.mail("test@test.com")
	.mail("test@test.com", "TestMail")
	.code("code block")
	.preformatted("public class SlackWebhookClientTest() {\n\n\tpublic static void main(String args[]) {\n\n\t}\n}")
	.quote("quote message")
	.build();
```

### v1.0.3.RELEASE
add "team.integrationLogs" method (https://twitter.com/SlackAPI/status/662350664782225408)

## Slack Web API compatibility
auth, channels, chat, emoji, files, groups, im, mpim, pins, reactions, stars, team, users
```java
package flowctrl.integration.slack.webapi;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import flowctrl.integration.slack.type.Attachment;
import flowctrl.integration.slack.type.Authentication;
import flowctrl.integration.slack.type.Channel;
import flowctrl.integration.slack.type.DirectMessageChannel;
import flowctrl.integration.slack.type.File;
import flowctrl.integration.slack.type.FileInfo;
import flowctrl.integration.slack.type.FileList;
import flowctrl.integration.slack.type.Group;
import flowctrl.integration.slack.type.History;
import flowctrl.integration.slack.type.PinItem;
import flowctrl.integration.slack.type.Presence;
import flowctrl.integration.slack.type.ReactionItem;
import flowctrl.integration.slack.type.ReactionList;
import flowctrl.integration.slack.type.StarList;
import flowctrl.integration.slack.type.Team;
import flowctrl.integration.slack.type.TeamAccessLogList;
import flowctrl.integration.slack.type.TeamIntegrationLogList;
import flowctrl.integration.slack.type.User;
import flowctrl.integration.slack.type.UserPresence;
import flowctrl.integration.slack.webapi.method.chats.ChatPostMessageMethod;

public interface SlackWebApiClient {
	
	void shutdown();
	
	// auth

	Authentication auth();
	
	// channels

	boolean archiveChannel(String channel);
	Channel createChannel(String name);
	History getChannelHistory(String channel);
	History getChannelHistory(String channel, int count);
	History getChannelHistory(String channel, String latest, String oldest, boolean inclusive, int count, boolean unreads);
	Channel getChannelInfo(String channel);
	Channel inviteUserToChannel(String channel, String user);
	Channel joinChannel(String name);
	boolean kickUserFormChannel(String channel, String user);
	boolean leaveChannel(String channel);
	List<Channel> getChannelList();
	List<Channel> getChannelList(boolean exclude_archived);
	boolean markChannel(String channel, String ts);
	Channel renameChannel(String channel, String name);
	boolean setChannelPurpose(String channel, String purpose);
	boolean setChannelTopic(String channel, String topic);
	boolean unarchiveChannel(String channel);
	
	// chat

	boolean deleteMessage(String channel, String ts);
	String postMessage(String channel, String text);
	String postMessage(String channel, String text, String username, boolean as_user);
	String postMessage(String channel, String text, String username, boolean as_user, boolean link_names, List<Attachment> attachments, boolean unfurl_links, boolean unfurl_media, String icon_url,
			String icon_emoji);
	String postMessage(ChatPostMessageMethod method);
	String updateMessage(String channel, String ts, String text);
	String updateMessage(String channel, String ts, String text, List<Attachment> attachments, boolean link_names);

	// emoji
	
	Map<String, String> getEmojiList();
	
	// files

	boolean deleteFile(String file);
	FileInfo getFileInfo(String file);
	FileInfo getFileInfo(String file, int page);
	FileInfo getFileInfo(String file, int page, int count);
	FileList getFileList();
	FileList getFileList(int page);
	FileList getFileList(int page, int count);
	FileList getFileList(String user);
	FileList getFileList(String user, int page);
	FileList getFileList(String user, int page, int count);
	FileList getFileList(String user, String ts_from, String ts_to, String types, int page, int count);
	File uploadFile(java.io.File file, String title, String initial_comment, String channels);
	File uploadFile(java.io.File file, String filetype, String filename, String title, String initial_comment, String channels);
	File uploadFile(InputStream is, String filetype, String filename, String title, String initial_comment, String channels);

	// groups
	
	boolean archiveGroup(String channel);
	boolean closeGroup(String channel);
	Group createGroup(String name);
	Group createChildGroup(String name);
	History getGroupHistory(String channel);
	History getGroupHistory(String channel, int count);
	History getGroupHistory(String channel, String latest, String oldest, boolean inclusive, int count, boolean unreads);
	Group getGroupInfo(String channel);
	Group inviteUserToGroup(String channel, String user);
	boolean kickUserFormGroup(String channel, String user);
	boolean leaveGroup(String channel);
	List<Group> getGroupList();
	List<Group> getGroupList(boolean exclude_archived);
	boolean markGroup(String channel, String ts);
	boolean openGroup(String channel);
	Group renameGroup(String channel, String name);
	boolean setGroupPurpose(String channel, String purpose);
	boolean setGroupTopic(String channel, String topic);
	boolean unarchiveGroup(String channel);
	
	// im (direct message channel)

	boolean closeDirectMessageChannel(String channel);
	History getDirectMessageChannelHistory(String channel);
	History getDirectMessageChannelHistory(String channel, int count);
	History getDirectMessageChannelHistory(String channel, String latest, String oldest, boolean inclusive, int count, boolean unreads);
	List<DirectMessageChannel> getDirectMessageChannelList();
	boolean markDirectMessageChannel(String channel, String ts);
	boolean openDirectMessageChannel(String user);
	
	// mpim (multiparty direct message channel)
	
	boolean closeMultipartyDirectMessageChannel(String channel);
	History getMultipartyDirectMessageChannelHistory(String channel);
	History getMultipartyDirectMessageChannelHistory(String channel, int count);
	History getMultipartyDirectMessageChannelHistory(String channel, String latest, String oldest, boolean inclusive, int count, boolean unreads);
	List<Group> getMultipartyDirectMessageChannelList();
	boolean markMultipartyDirectMessageChannel(String channel, String ts);
	Group openMultipartyDirectMessageChannel(String... users);
	Group openMultipartyDirectMessageChannel(List<String> users);

	// pins
	
	boolean pinFile(String channel, String file);
	boolean pinFileComment(String channel, String file_comment);
	boolean pinMessage(String channel, String timestamp);
	List<PinItem> getPinList(String channel);
	boolean unpinFile(String channel, String file);
	boolean unpinFileComment(String channel, String file_comment);
	boolean unpinMessage(String channel, String timestamp);

	// reactions
	
	boolean addReactionToFile(String emojiName, String file);
	boolean addReactionToFileComment(String emojiName, String file_comment);
	boolean addReactionToMessage(String emojiName, String channel, String timestamp);
	ReactionItem getReactionByFile(String emojiName, String file);
	ReactionItem getReactionByFileComment(String emojiName, String file_comment);
	ReactionItem getReactionByMessage(String emojiName, String channel, String timestamp);
	ReactionList getReactionList(int page);
	ReactionList getReactionList(int page, int count);
	ReactionList getReactionList(String user, int page);
	ReactionList getReactionList(String user, int page, int count);
	boolean removeReactionFromFile(String emojiName, String file);
	boolean removeReactionFromFileComment(String emojiName, String file_comment);
	boolean removeReactionFromMessage(String emojiName, String channel, String timestamp);
	
	// rtm
	
	String startRealTimeMessagingApi();
	String startRealTimeMessagingApi(String simple_latest, String no_unreads, String mpim_aware);

	// stars
	
	boolean addStarToFile(String file);
	boolean addStarToFileComment(String file_comment);
	boolean addStarToMessage(String channel, String timestamp);
	StarList getStarList(int page);
	StarList getStarList(int page, int count);
	StarList getStarList(String user, int page);
	StarList getStarList(String user, int page, int count);
	boolean removeStarFromFile(String file);
	boolean removeStarFromFileComment(String file_comment);
	boolean removeStarFromMessage(String channel, String timestamp);

	// team
	
	TeamAccessLogList getTeamAccessLogList(int page);
	TeamAccessLogList getTeamAccessLogList(int page, int count);
	Team getTeamInfo();
	TeamIntegrationLogList getTeamIntegrationLogList(int page);
	TeamIntegrationLogList getTeamIntegrationLogList(int page, int count);
	TeamIntegrationLogList getTeamIntegrationLogList(String service_id, String app_id, String user, String change_type, int page, int count);
	
	// users

	UserPresence getUserPresence(String user);
	User getUserInfo(String user);
	List<User> getUserList();
	List<User> getUserListWithPresence();
	boolean setActiveUser();
	boolean setPresenceUser(Presence presence);

}
```

## Maven
Step 1. Add the JitPack repository to your build file
```xml
<repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
</repository>
```
Step 2. Add the dependency in the form
```xml
<dependency>
    <groupId>com.github.flowctrl</groupId>
    <artifactId>slack-api</artifactId>
    <version>v1.0.7.RELEASE</version>
</dependency>
```

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

## Coming soon next
search, oauth

