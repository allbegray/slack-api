[![Release](https://img.shields.io/github/release/flowctrl/slack-api.svg?label=JitPack)](https://jitpack.io/#flowctrl/slack-api) [![Build Status](https://travis-ci.org/flowctrl/slack-api.svg?branch=master)](https://travis-ci.org/flowctrl/slack-api)

slack-api
=============
A Java client for the Slack Web API, Incoming Webhooks, Slackbot Remote Control, RTM(Real Time Messaging) API 

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
    <version>v1.1.0.RELEASE</version>
</dependency>
```

## Change Logs

### v1.1.0.RELEASE

[add method "dnd"](https://api.slack.com/methods#files.comments)  
[add method "files.comments"](https://api.slack.com/methods#dnd)

## Slack Web API compatibility
auth, channels, chat, dnd, emoji, files.comments. files, groups, im, mpim, oauth, pins, reactions, rtm, stars, team, usergroups, usergroups.users, users
```java
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

	// dnd
	
	boolean endDnd();
	EndSnooze endSnooze();
	SetSnooze setSnooze(int num_minutes);
	DndInfo getDndInfo();
	DndInfo getDndInfo(String user);
	Map<String, DndSimpleInfo> getDndTeamInfo();
	Map<String, DndSimpleInfo> getDndTeamInfo(List<String> users);
	
	// emoji
	
	Map<String, String> getEmojiList();
	
	// files.comments
	
	Comment addFileComment(String file, String comment);
	Comment editFileComment(String file, String id, String comment);
	boolean deleteFileComment(String file, String id);
	
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
	String openDirectMessageChannel(String user);

	// mpim (multiparty direct message channel)

	boolean closeMultipartyDirectMessageChannel(String channel);
	History getMultipartyDirectMessageChannelHistory(String channel);
	History getMultipartyDirectMessageChannelHistory(String channel, int count);
	History getMultipartyDirectMessageChannelHistory(String channel, String latest, String oldest, boolean inclusive, int count, boolean unreads);
	List<Group> getMultipartyDirectMessageChannelList();
	boolean markMultipartyDirectMessageChannel(String channel, String ts);
	Group openMultipartyDirectMessageChannel(String... users);
	Group openMultipartyDirectMessageChannel(List<String> users);

	// oauth
	
	OAuthAccessToken accessOAuth(String client_id, String client_secret, String code, String redirect_uri);

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
	
	// usergroups
	
	Usergroup createUsergroup(String name, String handle, String description, List<String> channels);
	Usergroup createUsergroup(String name, String handle, String description, List<String> channels, boolean include_count);
	Usergroup disableUsergroup(String usergroup);
	Usergroup disableUsergroup(String usergroup, boolean include_count);
	Usergroup enableUsergroup(String usergroup);
	Usergroup enableUsergroup(String usergroup, boolean include_count);
	List<Usergroup> getUsergroupList();
	List<Usergroup> getUsergroupList(boolean include_disabled, boolean include_count, boolean include_users);
	Usergroup updateUsergroup(String name, String handle, String description, List<String> channels);
	Usergroup updateUsergroup(String name, String handle, String description, List<String> channels, boolean include_count);
	
	// usergroups.users
	
	List<String> getUsergroupUserList(String usergroup);
	List<String> getUsergroupUserList(String usergroup, boolean include_disabled);
	Usergroup updateUsergroupUser(String usergroup, List<String> users);
	Usergroup updateUsergroupUser(String usergroup, List<String> users, boolean include_count);
	
	// users

	UserPresence getUserPresence(String user);
	User getUserInfo(String user);
	List<User> getUserList();
	List<User> getUserListWithPresence();
	boolean setActiveUser();
	boolean setPresenceUser(Presence presence);

}
```

## Slack client factory
```java

SlackWebApiClient webApiClient = SlackClientFactory.createWebApiClient(token);

SlackWebhookClient webhookClient = SlackClientFactory.createWebhookClient(webhookUrl);

SlackbotClient slackbotClient = SlackClientFactory.createSlackbotClient(slackbotUrl);

SlackRealTimeMessagingClient createSlackRealTimeMessagingClient(String token)

```

## Coming soon next
search

