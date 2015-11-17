package flowctrl.integration.slack.webapi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.impl.client.CloseableHttpClient;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import flowctrl.integration.slack.RestUtils;
import flowctrl.integration.slack.exception.SlackArgumentException;
import flowctrl.integration.slack.exception.SlackException;
import flowctrl.integration.slack.exception.SlackResponseErrorException;
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
import flowctrl.integration.slack.validation.Problem;
import flowctrl.integration.slack.validation.ValidationError;
import flowctrl.integration.slack.webapi.method.SlackMethod;
import flowctrl.integration.slack.webapi.method.channels.ChannelArchiveMethod;
import flowctrl.integration.slack.webapi.method.channels.ChannelCreateMethod;
import flowctrl.integration.slack.webapi.method.channels.ChannelHistoryMethod;
import flowctrl.integration.slack.webapi.method.channels.ChannelInfoMethod;
import flowctrl.integration.slack.webapi.method.channels.ChannelInviteMethod;
import flowctrl.integration.slack.webapi.method.channels.ChannelJoinMethod;
import flowctrl.integration.slack.webapi.method.channels.ChannelKickMethod;
import flowctrl.integration.slack.webapi.method.channels.ChannelLeaveMethod;
import flowctrl.integration.slack.webapi.method.channels.ChannelListMethod;
import flowctrl.integration.slack.webapi.method.channels.ChannelMarkMethod;
import flowctrl.integration.slack.webapi.method.channels.ChannelRenameMethod;
import flowctrl.integration.slack.webapi.method.channels.ChannelSetPurposeMethod;
import flowctrl.integration.slack.webapi.method.channels.ChannelSetTopicMethod;
import flowctrl.integration.slack.webapi.method.channels.ChannelUnarchiveMethod;
import flowctrl.integration.slack.webapi.method.chats.ChatDeleteMethod;
import flowctrl.integration.slack.webapi.method.chats.ChatPostMessageMethod;
import flowctrl.integration.slack.webapi.method.chats.ChatUpdateMethod;
import flowctrl.integration.slack.webapi.method.emoji.EmojiListMethod;
import flowctrl.integration.slack.webapi.method.files.FileDeleteMethod;
import flowctrl.integration.slack.webapi.method.files.FileInfoMethod;
import flowctrl.integration.slack.webapi.method.files.FileListMethod;
import flowctrl.integration.slack.webapi.method.files.FileUploadMethod;
import flowctrl.integration.slack.webapi.method.groups.GroupArchiveMethod;
import flowctrl.integration.slack.webapi.method.groups.GroupCloseMethod;
import flowctrl.integration.slack.webapi.method.groups.GroupCreateChildMethod;
import flowctrl.integration.slack.webapi.method.groups.GroupCreateMethod;
import flowctrl.integration.slack.webapi.method.groups.GroupHistoryMethod;
import flowctrl.integration.slack.webapi.method.groups.GroupInfoMethod;
import flowctrl.integration.slack.webapi.method.groups.GroupInviteMethod;
import flowctrl.integration.slack.webapi.method.groups.GroupKickMethod;
import flowctrl.integration.slack.webapi.method.groups.GroupLeaveMethod;
import flowctrl.integration.slack.webapi.method.groups.GroupListMethod;
import flowctrl.integration.slack.webapi.method.groups.GroupMarkMethod;
import flowctrl.integration.slack.webapi.method.groups.GroupOpenMethod;
import flowctrl.integration.slack.webapi.method.groups.GroupRenameMethod;
import flowctrl.integration.slack.webapi.method.groups.GroupSetPurposeMethod;
import flowctrl.integration.slack.webapi.method.groups.GroupSetTopicMethod;
import flowctrl.integration.slack.webapi.method.groups.GroupUnarchiveMethod;
import flowctrl.integration.slack.webapi.method.im.ImCloseMethod;
import flowctrl.integration.slack.webapi.method.im.ImHistoryMethod;
import flowctrl.integration.slack.webapi.method.im.ImListMethod;
import flowctrl.integration.slack.webapi.method.im.ImMarkMethod;
import flowctrl.integration.slack.webapi.method.im.ImOpenMethod;
import flowctrl.integration.slack.webapi.method.mpim.MpimCloseMethod;
import flowctrl.integration.slack.webapi.method.mpim.MpimHistoryMethod;
import flowctrl.integration.slack.webapi.method.mpim.MpimListMethod;
import flowctrl.integration.slack.webapi.method.mpim.MpimMarkMethod;
import flowctrl.integration.slack.webapi.method.mpim.MpimOpenMethod;
import flowctrl.integration.slack.webapi.method.pins.PinsAddMethod;
import flowctrl.integration.slack.webapi.method.pins.PinsListMethod;
import flowctrl.integration.slack.webapi.method.pins.PinsRemoveMethod;
import flowctrl.integration.slack.webapi.method.reactions.ReactionsAddMethod;
import flowctrl.integration.slack.webapi.method.reactions.ReactionsGetMethod;
import flowctrl.integration.slack.webapi.method.reactions.ReactionsListMethod;
import flowctrl.integration.slack.webapi.method.reactions.ReactionsRemoveMethod;
import flowctrl.integration.slack.webapi.method.rtm.RtmStartMethod;
import flowctrl.integration.slack.webapi.method.stars.StarsAddMethod;
import flowctrl.integration.slack.webapi.method.stars.StarsListMethod;
import flowctrl.integration.slack.webapi.method.stars.StarsRemoveMethod;
import flowctrl.integration.slack.webapi.method.team.TeamAccessLogsMethod;
import flowctrl.integration.slack.webapi.method.team.TeamInfoMethod;
import flowctrl.integration.slack.webapi.method.team.TeamIntegrationLogMethod;
import flowctrl.integration.slack.webapi.method.test.AuthTestMethod;
import flowctrl.integration.slack.webapi.method.users.UserGetPresenceMethod;
import flowctrl.integration.slack.webapi.method.users.UserInfoMethod;
import flowctrl.integration.slack.webapi.method.users.UserListMethod;
import flowctrl.integration.slack.webapi.method.users.UserSetActiveMethod;
import flowctrl.integration.slack.webapi.method.users.UserSetPresenceMethod;

public class SlackWebApiClientImpl implements SlackWebApiClient {

	private String token;
	private ObjectMapper mapper;
	private CloseableHttpClient httpClient;

	public SlackWebApiClientImpl(String token) {
		this(token, null);
	}

	public SlackWebApiClientImpl(String token, ObjectMapper mapper) {
		this(token, mapper, SlackWebApiConstants.DEFAULT_TIMEOUT);
	}

	public SlackWebApiClientImpl(String token, ObjectMapper mapper, int timeout) {
		this.token = token;
		this.mapper = mapper != null ? mapper : new ObjectMapper();
		httpClient = RestUtils.createHttpClient(timeout);
	}

	@Override
	public void shutdown() {
		if (httpClient != null) try { httpClient.close(); } catch (Exception e) {}
	}

	// auth methods

	@Override
	public Authentication auth() {
		JsonNode retNode = call(new AuthTestMethod());
		return readValue(retNode, null, Authentication.class);
	}

	// channels

	@Override
	public boolean archiveChannel(String channel) {
		return isOk(new ChannelArchiveMethod(channel));
	}

	@Override
	public Channel createChannel(String name) {
		JsonNode retNode = call(new ChannelCreateMethod(name));
		return readValue(retNode, "channel", Channel.class);
	}

	@Override
	public History getChannelHistory(String channel) {
		return getChannelHistory(channel, null, null, false, SlackWebApiConstants.DEFAULT_COUNT, false);
	}

	@Override
	public History getChannelHistory(String channel, int count) {
		return getChannelHistory(channel, null, null, false, count, false);
	}

	@Override
	public History getChannelHistory(String channel, String latest, String oldest, boolean inclusive, int count, boolean unreads) {

		ChannelHistoryMethod channelHistoryMethod = new ChannelHistoryMethod(channel);
		channelHistoryMethod.setLatest(latest);
		channelHistoryMethod.setOldest(oldest);
		channelHistoryMethod.setInclusive(inclusive);
		channelHistoryMethod.setCount(count);
		channelHistoryMethod.setUnreads(unreads);

		JsonNode retNode = call(channelHistoryMethod);
		return readValue(retNode, null, History.class);
	}

	@Override
	public Channel getChannelInfo(String channel) {
		JsonNode retNode = call(new ChannelInfoMethod(channel));
		return readValue(retNode, "channel", Channel.class);
	}

	@Override
	public Channel inviteUserToChannel(String channel, String user) {
		JsonNode retNode = call(new ChannelInviteMethod(channel, user));
		return readValue(retNode, "channel", Channel.class);
	}

	@Override
	public Channel joinChannel(String name) {
		JsonNode retNode = call(new ChannelJoinMethod(name));
		return readValue(retNode, "channel", Channel.class);
	}

	@Override
	public boolean kickUserFormChannel(String channel, String user) {
		return isOk(new ChannelKickMethod(channel, user));
	}

	@Override
	public boolean leaveChannel(String channel) {
		return isOk(new ChannelLeaveMethod(channel));
	}

	@Override
	public List<Channel> getChannelList() {
		return getChannelList(false);
	}

	@Override
	public List<Channel> getChannelList(boolean exclude_archived) {
		JsonNode retNode = call(new ChannelListMethod(exclude_archived));

		return readValue(retNode, "channels", new TypeReference<List<Channel>>() {
		});
	}

	@Override
	public boolean markChannel(String channel, String ts) {
		return isOk(new ChannelMarkMethod(channel, ts));
	}

	@Override
	public Channel renameChannel(String channel, String name) {
		JsonNode retNode = call(new ChannelRenameMethod(channel, name));
		return readValue(retNode, "channel", Channel.class);
	}

	@Override
	public boolean setChannelPurpose(String channel, String purpose) {
		return isOk(new ChannelSetPurposeMethod(channel, purpose));
	}

	@Override
	public boolean setChannelTopic(String channel, String topic) {
		return isOk(new ChannelSetTopicMethod(channel, topic));
	}

	@Override
	public boolean unarchiveChannel(String channel) {
		return isOk(new ChannelUnarchiveMethod(channel));
	}

	// chat

	@Override
	public boolean deleteMessage(String channel, String ts) {
		return isOk(new ChatDeleteMethod(channel, ts));
	}

	@Override
	public String postMessage(String channel, String text) {
		return postMessage(new ChatPostMessageMethod(channel, text));
	}

	@Override
	public String postMessage(String channel, String text, String username, boolean as_user) {
		ChatPostMessageMethod method = new ChatPostMessageMethod(channel, text);
		method.setUsername(username);
		method.setAs_user(as_user);

		return postMessage(method);
	}

	@Override
	public String postMessage(String channel, String text, String username, boolean as_user, boolean link_names, List<Attachment> attachments, boolean unfurl_links, boolean unfurl_media,
			String icon_url, String icon_emoji) {

		ChatPostMessageMethod method = new ChatPostMessageMethod(channel, text);
		method.setUsername(username);
		method.setLink_names(link_names);
		method.setAttachments(attachments);
		method.setUnfurl_links(unfurl_links);
		method.setUnfurl_media(unfurl_media);
		method.setIcon_url(icon_url);
		method.setIcon_emoji(icon_emoji);

		return postMessage(method);
	}

	@Override
	public String postMessage(ChatPostMessageMethod method) {
		if (method.getMapper() == null) {
			method.setMapper(mapper);
		}

		JsonNode retNode = call(method);
		return retNode.findPath("ts").asText();
	}

	@Override
	public String updateMessage(String channel, String ts, String text) {
		return updateMessage(channel, ts, text, null, false);
	}

	@Override
	public String updateMessage(String channel, String ts, String text, List<Attachment> attachments, boolean link_names) {
		ChatUpdateMethod method = new ChatUpdateMethod(channel, ts, text);
		method.setAttachments(attachments);
		method.setLink_names(link_names);
		method.setMapper(mapper);

		JsonNode retNode = call(method);
		return retNode.findPath("ts").asText();
	}

	// emoji

	@Override
	public Map<String, String> getEmojiList() {
		JsonNode retNode = call(new EmojiListMethod());

		return readValue(retNode, "emoji", new TypeReference<Map<String, String>>() {
		});
	}

	// files

	@Override
	public boolean deleteFile(String file) {
		return isOk(new FileDeleteMethod(file));
	}

	@Override
	public FileInfo getFileInfo(String file) {
		return getFileInfo(file, SlackWebApiConstants.DEFAULT_PAGE);
	}

	@Override
	public FileInfo getFileInfo(String file, int page) {
		return getFileInfo(file, page, SlackWebApiConstants.DEFAULT_COUNT);
	}

	@Override
	public FileInfo getFileInfo(String file, int page, int count) {
		FileInfoMethod method = new FileInfoMethod(file);
		method.setPage(page);
		method.setCount(count);

		JsonNode retNode = call(method);
		return readValue(retNode, null, FileInfo.class);
	}

	@Override
	public FileList getFileList() {
		return getFileList(null, null, null, null, SlackWebApiConstants.DEFAULT_PAGE, SlackWebApiConstants.DEFAULT_COUNT);
	}

	@Override
	public FileList getFileList(int page) {
		return getFileList(null, null, null, null, page, SlackWebApiConstants.DEFAULT_COUNT);
	}

	@Override
	public FileList getFileList(int page, int count) {
		return getFileList(null, null, null, null, page, count);
	}

	@Override
	public FileList getFileList(String user) {
		return getFileList(user, null, null, null, SlackWebApiConstants.DEFAULT_PAGE, SlackWebApiConstants.DEFAULT_COUNT);
	}

	@Override
	public FileList getFileList(String user, int page) {
		return getFileList(user, null, null, null, page, SlackWebApiConstants.DEFAULT_COUNT);
	}

	@Override
	public FileList getFileList(String user, int page, int count) {
		return getFileList(user, null, null, null, page, count);
	}

	@Override
	public FileList getFileList(String user, String ts_from, String ts_to, String types, int page, int count) {
		FileListMethod method = new FileListMethod();
		method.setUser(user);
		method.setTs_from(ts_from);
		method.setTs_to(ts_to);
		method.setTypes(types);
		method.setPage(page);
		method.setCount(count);

		JsonNode retNode = call(method);
		return readValue(retNode, null, FileList.class);
	}

	@Override
	public File uploadFile(java.io.File file, String title, String initial_comment, String channels) {
		String filename = file.getName();
		String filetype = null;
		int i = filename.lastIndexOf('.');
		if (i > 0) {
			filetype = filename.substring(i + 1);
		}
		return uploadFile(file, filetype, filename, title, initial_comment, channels);
	}

	@Override
	public File uploadFile(java.io.File file, String filetype, String filename, String title, String initial_comment, String channels) {
		try {
			return uploadFile(new FileInputStream(file), filetype, filename, title, initial_comment, channels);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public File uploadFile(InputStream is, String filetype, String filename, String title, String initial_comment, String channels) {
		FileUploadMethod method = new FileUploadMethod();
		method.setChannels(channels);
		method.setFilename(filename);
		method.setFiletype(filetype);
		method.setInitial_comment(initial_comment);
		method.setTitle(title);

		JsonNode retNode = call(method, is);
		return readValue(retNode, "file", File.class);
	}

	// groups

	@Override
	public boolean archiveGroup(String channel) {
		return isOk(new GroupArchiveMethod(channel));
	}

	@Override
	public boolean closeGroup(String channel) {
		return isOk(new GroupCloseMethod(channel));
	}

	@Override
	public Group createGroup(String name) {
		JsonNode retNode = call(new GroupCreateMethod(name));
		return readValue(retNode, "group", Group.class);
	}

	@Override
	public Group createChildGroup(String name) {
		JsonNode retNode = call(new GroupCreateChildMethod(name));
		return readValue(retNode, "group", Group.class);
	}

	@Override
	public History getGroupHistory(String channel) {
		return getGroupHistory(channel, null, null, false, SlackWebApiConstants.DEFAULT_COUNT, false);
	}

	@Override
	public History getGroupHistory(String channel, int count) {
		return getGroupHistory(channel, null, null, false, count, false);
	}

	@Override
	public History getGroupHistory(String channel, String latest, String oldest, boolean inclusive, int count, boolean unreads) {

		GroupHistoryMethod channelHistoryMethod = new GroupHistoryMethod(channel);
		channelHistoryMethod.setLatest(latest);
		channelHistoryMethod.setOldest(oldest);
		channelHistoryMethod.setInclusive(inclusive);
		channelHistoryMethod.setCount(count);
		channelHistoryMethod.setUnreads(unreads);

		JsonNode retNode = call(channelHistoryMethod);
		return readValue(retNode, null, History.class);
	}

	@Override
	public Group getGroupInfo(String channel) {
		JsonNode retNode = call(new GroupInfoMethod(channel));
		return readValue(retNode, "group", Group.class);
	}

	@Override
	public Group inviteUserToGroup(String channel, String user) {
		JsonNode retNode = call(new GroupInviteMethod(channel, user));
		return readValue(retNode, "group", Group.class);
	}

	@Override
	public boolean kickUserFormGroup(String channel, String user) {
		return isOk(new GroupKickMethod(channel, user));
	}

	@Override
	public boolean leaveGroup(String channel) {
		return isOk(new GroupLeaveMethod(channel));
	}

	@Override
	public List<Group> getGroupList() {
		return getGroupList(false);
	}

	@Override
	public List<Group> getGroupList(boolean exclude_archived) {
		JsonNode retNode = call(new GroupListMethod(exclude_archived));

		return readValue(retNode, "groups", new TypeReference<List<Group>>() {
		});
	}

	@Override
	public boolean markGroup(String channel, String ts) {
		return isOk(new GroupMarkMethod(channel, ts));
	}

	@Override
	public boolean openGroup(String channel) {
		return isOk(new GroupOpenMethod(channel));
	}

	@Override
	public Group renameGroup(String channel, String name) {
		JsonNode retNode = call(new GroupRenameMethod(channel, name));
		return readValue(retNode, "channel", Group.class);
	}

	@Override
	public boolean setGroupPurpose(String channel, String purpose) {
		return isOk(new GroupSetPurposeMethod(channel, purpose));
	}

	@Override
	public boolean setGroupTopic(String channel, String topic) {
		return isOk(new GroupSetTopicMethod(channel, topic));
	}

	@Override
	public boolean unarchiveGroup(String channel) {
		return isOk(new GroupUnarchiveMethod(channel));
	}

	// im (direct message channel)

	@Override
	public boolean closeDirectMessageChannel(String channel) {
		return isOk(new ImCloseMethod(channel));
	}

	@Override
	public History getDirectMessageChannelHistory(String channel) {
		return getDirectMessageChannelHistory(channel, null, null, false, SlackWebApiConstants.DEFAULT_COUNT, false);
	}

	@Override
	public History getDirectMessageChannelHistory(String channel, int count) {
		return getDirectMessageChannelHistory(channel, null, null, false, count, false);
	}

	@Override
	public History getDirectMessageChannelHistory(String channel, String latest, String oldest, boolean inclusive, int count, boolean unreads) {

		ImHistoryMethod imHistoryMethod = new ImHistoryMethod(channel);
		imHistoryMethod.setLatest(latest);
		imHistoryMethod.setOldest(oldest);
		imHistoryMethod.setInclusive(inclusive);
		imHistoryMethod.setCount(count);
		imHistoryMethod.setUnreads(unreads);

		JsonNode retNode = call(imHistoryMethod);
		return readValue(retNode, null, History.class);
	}

	@Override
	public List<DirectMessageChannel> getDirectMessageChannelList() {
		JsonNode retNode = call(new ImListMethod());

		return readValue(retNode, "ims", new TypeReference<List<DirectMessageChannel>>() {
		});
	}

	@Override
	public boolean markDirectMessageChannel(String channel, String ts) {
		return isOk(new ImMarkMethod(channel, ts));
	}

	@Override
	public boolean openDirectMessageChannel(String user) {
		return isOk(new ImOpenMethod(user));
	}

	// mpim (multiparty direct message channel)

	@Override
	public boolean closeMultipartyDirectMessageChannel(String channel) {
		return isOk(new MpimCloseMethod(channel));
	}

	@Override
	public History getMultipartyDirectMessageChannelHistory(String channel) {
		return getMultipartyDirectMessageChannelHistory(channel, null, null, false, SlackWebApiConstants.DEFAULT_COUNT, false);
	}

	@Override
	public History getMultipartyDirectMessageChannelHistory(String channel, int count) {
		return getMultipartyDirectMessageChannelHistory(channel, null, null, false, count, false);
	}

	@Override
	public History getMultipartyDirectMessageChannelHistory(String channel, String latest, String oldest, boolean inclusive, int count, boolean unreads) {

		MpimHistoryMethod mpimHistoryMethod = new MpimHistoryMethod(channel);
		mpimHistoryMethod.setLatest(latest);
		mpimHistoryMethod.setOldest(oldest);
		mpimHistoryMethod.setInclusive(inclusive);
		mpimHistoryMethod.setCount(count);
		mpimHistoryMethod.setUnreads(unreads);

		JsonNode retNode = call(mpimHistoryMethod);
		return readValue(retNode, null, History.class);
	}

	@Override
	public List<Group> getMultipartyDirectMessageChannelList() {
		JsonNode retNode = call(new MpimListMethod());
		return readValue(retNode, "groups", new TypeReference<List<Group>>() {
		});
	}

	@Override
	public boolean markMultipartyDirectMessageChannel(String channel, String ts) {
		return isOk(new MpimMarkMethod(channel, ts));
	}

	@Override
	public Group openMultipartyDirectMessageChannel(String... users) {
		return openMultipartyDirectMessageChannel(Arrays.asList(users));
	}

	@Override
	public Group openMultipartyDirectMessageChannel(List<String> users) {
		JsonNode retNode = call(new MpimOpenMethod(users));
		return readValue(retNode, "group", Group.class);
	}

	// oauth

	// pins

	@Override
	public boolean pinFile(String channel, String file) {
		PinsAddMethod method = new PinsAddMethod(channel);
		method.setFile(file);

		return isOk(method);
	}

	@Override
	public boolean pinFileComment(String channel, String file_comment) {
		PinsAddMethod method = new PinsAddMethod(channel);
		method.setFile_comment(file_comment);

		return isOk(method);
	}

	@Override
	public boolean pinMessage(String channel, String timestamp) {
		PinsAddMethod method = new PinsAddMethod(channel);
		method.setTimestamp(timestamp);

		return isOk(method);
	}

	@Override
	public List<PinItem> getPinList(String channel) {
		JsonNode retNode = call(new PinsListMethod(channel));
		return readValue(retNode, "items", new TypeReference<List<PinItem>>() {
		});
	}

	@Override
	public boolean unpinFile(String channel, String file) {
		PinsRemoveMethod method = new PinsRemoveMethod(channel);
		method.setFile(file);

		return isOk(method);
	}

	@Override
	public boolean unpinFileComment(String channel, String file_comment) {
		PinsRemoveMethod method = new PinsRemoveMethod(channel);
		method.setFile_comment(file_comment);

		return isOk(method);
	}

	@Override
	public boolean unpinMessage(String channel, String timestamp) {
		PinsRemoveMethod method = new PinsRemoveMethod(channel);
		method.setTimestamp(timestamp);

		return isOk(method);
	}

	// reactions

	@Override
	public boolean addReactionToFile(String emojiName, String file) {
		ReactionsAddMethod method = new ReactionsAddMethod(emojiName);
		method.setFile(file);

		return isOk(method);
	}

	@Override
	public boolean addReactionToFileComment(String emojiName, String file_comment) {
		ReactionsAddMethod method = new ReactionsAddMethod(emojiName);
		method.setFile_comment(file_comment);

		return isOk(method);
	}

	@Override
	public boolean addReactionToMessage(String emojiName, String channel, String timestamp) {
		ReactionsAddMethod method = new ReactionsAddMethod(emojiName);
		method.setChannel(channel);
		method.setTimestamp(timestamp);

		return isOk(method);
	}

	@Override
	public ReactionItem getReactionByFile(String emojiName, String file) {
		ReactionsGetMethod method = new ReactionsGetMethod(emojiName);
		method.setFile(file);

		JsonNode retNode = call(method);
		return readValue(retNode, "message", ReactionItem.class);
	}

	@Override
	public ReactionItem getReactionByFileComment(String emojiName, String file_comment) {
		ReactionsGetMethod method = new ReactionsGetMethod(emojiName);
		method.setFile_comment(file_comment);

		JsonNode retNode = call(method);
		return readValue(retNode, "message", ReactionItem.class);
	}

	@Override
	public ReactionItem getReactionByMessage(String emojiName, String channel, String timestamp) {
		ReactionsGetMethod method = new ReactionsGetMethod(emojiName);
		method.setChannel(channel);
		method.setTimestamp(timestamp);

		JsonNode retNode = call(method);
		return readValue(retNode, "message", ReactionItem.class);
	}

	@Override
	public ReactionList getReactionList(int page) {
		return this.getReactionList(page, SlackWebApiConstants.DEFAULT_COUNT);
	}

	@Override
	public ReactionList getReactionList(int page, int count) {
		return this.getReactionList(null, page, count);
	}

	@Override
	public ReactionList getReactionList(String user, int page) {
		return this.getReactionList(user, page, SlackWebApiConstants.DEFAULT_COUNT);
	}

	@Override
	public ReactionList getReactionList(String user, int page, int count) {
		ReactionsListMethod method = new ReactionsListMethod();
		method.setUser(user);
		method.setPage(page);
		method.setCount(count);

		JsonNode retNode = call(method);
		return readValue(retNode, null, ReactionList.class);
	}

	@Override
	public boolean removeReactionToFile(String emojiName, String file) {
		ReactionsRemoveMethod method = new ReactionsRemoveMethod(emojiName);
		method.setFile(file);

		return isOk(method);
	}

	@Override
	public boolean removeReactionToFileComment(String emojiName, String file_comment) {
		ReactionsRemoveMethod method = new ReactionsRemoveMethod(emojiName);
		method.setFile_comment(file_comment);

		return isOk(method);
	}

	@Override
	public boolean removeReactionToMessage(String emojiName, String channel, String timestamp) {
		ReactionsRemoveMethod method = new ReactionsRemoveMethod(emojiName);
		method.setChannel(channel);
		method.setTimestamp(timestamp);

		return isOk(method);
	}

	// rtm

	@Override
	public String startRealTimeMessagingApi() {
		return startRealTimeMessagingApi(null, null, null);
	}

	@Override
	public String startRealTimeMessagingApi(String simple_latest, String no_unreads, String mpim_aware) {
		RtmStartMethod method = new RtmStartMethod();
		method.setSimple_latest(simple_latest);
		method.setNo_unreads(no_unreads);
		method.setMpim_aware(mpim_aware);

		JsonNode retNode = call(method);
		return retNode.findPath("url").asText();
	}

	// search

	// stars

	@Override
	public boolean addStarToFile(String file) {
		StarsAddMethod method = new StarsAddMethod();
		method.setFile(file);

		return isOk(method);
	}

	@Override
	public boolean addStarToFileComment(String file_comment) {
		StarsAddMethod method = new StarsAddMethod();
		method.setFile_comment(file_comment);

		return isOk(method);
	}

	@Override
	public boolean addStarToMessage(String channel, String timestamp) {
		StarsAddMethod method = new StarsAddMethod();
		method.setChannel(channel);
		method.setTimestamp(timestamp);

		return isOk(method);
	}

	@Override
	public StarList getStarList(int page) {
		return this.getStarList(page, SlackWebApiConstants.DEFAULT_COUNT);
	}

	@Override
	public StarList getStarList(int page, int count) {
		return this.getStarList(null, page, count);
	}

	@Override
	public StarList getStarList(String user, int page) {
		return this.getStarList(user, page, SlackWebApiConstants.DEFAULT_COUNT);
	}

	@Override
	public StarList getStarList(String user, int page, int count) {
		StarsListMethod method = new StarsListMethod();
		method.setUser(user);
		method.setPage(page);
		method.setCount(count);

		JsonNode retNode = call(method);
		return readValue(retNode, null, StarList.class);
	}

	@Override
	public boolean removeStarToFile(String file) {
		StarsRemoveMethod method = new StarsRemoveMethod();
		method.setFile(file);

		return isOk(method);
	}

	@Override
	public boolean removeStarToFileComment(String file_comment) {
		StarsRemoveMethod method = new StarsRemoveMethod();
		method.setFile_comment(file_comment);

		return isOk(method);
	}

	@Override
	public boolean removeStarToMessage(String channel, String timestamp) {
		StarsRemoveMethod method = new StarsRemoveMethod();
		method.setChannel(channel);
		method.setTimestamp(timestamp);

		return isOk(method);
	}

	// team

	@Override
	public TeamAccessLogList getTeamAccessLogList(int page) {
		return this.getTeamAccessLogList(page, SlackWebApiConstants.DEFAULT_COUNT);
	}

	@Override
	public TeamAccessLogList getTeamAccessLogList(int page, int count) {
		TeamAccessLogsMethod method = new TeamAccessLogsMethod();
		method.setPage(page);
		method.setCount(count);

		JsonNode retNode = call(method);
		return readValue(retNode, null, TeamAccessLogList.class);
	}

	@Override
	public Team getTeamInfo() {
		JsonNode retNode = call(new TeamInfoMethod());
		return readValue(retNode, "team", Team.class);
	}

	@Override
	public TeamIntegrationLogList getTeamIntegrationLogList(int page) {
		return getTeamIntegrationLogList(null, null, null, null, page, SlackWebApiConstants.DEFAULT_COUNT);
	}

	@Override
	public TeamIntegrationLogList getTeamIntegrationLogList(int page, int count) {
		return getTeamIntegrationLogList(null, null, null, null, page, count);
	}

	@Override
	public TeamIntegrationLogList getTeamIntegrationLogList(String service_id, String app_id, String user, String change_type, int page, int count) {
		TeamIntegrationLogMethod method = new TeamIntegrationLogMethod();
		method.setService_id(service_id);
		method.setApp_id(app_id);
		method.setUser(user);
		method.setChange_type(change_type);
		method.setPage(page);
		method.setCount(count);

		JsonNode retNode = call(method);
		return readValue(retNode, null, TeamIntegrationLogList.class);
	}

	// users

	@Override
	public UserPresence getUserPresence(String user) {
		JsonNode retNode = call(new UserGetPresenceMethod(user));
		return readValue(retNode, null, UserPresence.class);
	}

	@Override
	public User getUserInfo(String user) {
		JsonNode retNode = call(new UserInfoMethod(user));
		return readValue(retNode, "user", User.class);
	}

	@Override
	public List<User> getUserList() {
		JsonNode retNode = call(new UserListMethod());
		return readValue(retNode, "members", new TypeReference<List<User>>() {
		});
	}

	@Override
	public List<User> getUserListWithPresence() {
		JsonNode retNode = call(new UserListMethod("1"));
		return readValue(retNode, "members", new TypeReference<List<User>>() {
		});
	}

	@Override
	public boolean setActiveUser() {
		return isOk(new UserSetActiveMethod());
	}

	@Override
	public boolean setPresenceUser(Presence presence) {
		if (presence == null) {
			throw new SlackArgumentException("invalid presence(auto|away)");
		}
		return isOk(new UserSetPresenceMethod(presence.name().toLowerCase()));
	}

	// function

	protected boolean isOk(SlackMethod method) {
		JsonNode retNode = call(method);
		return retNode.findPath("ok").asBoolean();
	}

	protected <T> T readValue(JsonNode node, String findPath, Class<T> valueType) {
		try {
			if (findPath != null) {
				node = node.findPath(findPath);
			}
			return mapper.readValue(node.toString(), valueType);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	protected <T> T readValue(JsonNode node, String findPath, TypeReference<?> typeReference) {
		try {
			if (findPath != null) {
				node = node.findPath(findPath);
			}
			return mapper.readValue(node.toString(), typeReference);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	protected JsonNode call(SlackMethod method) {
		return call(method, null);
	}

	protected JsonNode call(SlackMethod method, InputStream is) {

		List<ValidationError> errors = new ArrayList<ValidationError>();
		method.validate(errors);

		if (errors.size() > 0) {

			StringBuffer sb = new StringBuffer("*** slack argument error ***");
			for (ValidationError error : errors) {
				if (sb.length() > 0) {
					sb.append("\n");
				}

				if (error.getDescription() != null) {
					sb.append(error.getDescription());
				} else if (error.getProblem() == Problem.REQUIRED) {
					sb.append("\"" + error.getField() + "\" is required.");
				}
			}

			throw new SlackArgumentException(sb.toString());
		}

		Map<String, String> parameters = method.getParameters();
		if (method.isRequiredToken()) {
			parameters.put("token", token);
		}

		String apiUrl = SlackWebApiConstants.SLACK_WEB_API_URL + "/" + method.getMethodName();

		HttpEntity httpEntity = null;
		if (is == null) {
			httpEntity = RestUtils.createUrlEncodedFormEntity(parameters);
		} else {
			httpEntity = RestUtils.createMultipartFormEntity(parameters, is);
		}

		String retStr = RestUtils.execute(httpClient, apiUrl, httpEntity);

		JsonNode retNode = null;
		try {
			retNode = mapper.readTree(retStr);
		} catch (IOException e) {
			throw new SlackException(e);
		}

		boolean retOk = retNode.findPath("ok").asBoolean();
		if (!retOk) {
			String error = retNode.findPath("error").asText();
			throw new SlackResponseErrorException(error + ". check the link " + SlackWebApiConstants.SLACK_WEB_API_DOCUMENT_URL + "/" + method.getMethodName());
		}

		return retNode;
	}

}
