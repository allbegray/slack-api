package allbegray.slack.webapi;

public interface SlackWebApiConstants {

	String SLACK_WEB_API_URL = "https://slack.com/api";
	String SLACK_WEB_API_DOCUMENT_URL = "https://api.slack.com/methods";

	int DEFAULT_TIMEOUT = 5000;

	int DEFAULT_COUNT = 100;
	int DEFAULT_PAGE = 1;

	// test

	String API_TEST = "api.test";
	String AUTH_TEST = "auth.test";

	// bots

	String BOTS_INFO = "bots.info";

	// channels

	String CHANNELS_ARCHIVE = "channels.archive";
	String CHANNELS_CREATE = "channels.create";
	String CHANNELS_HISTORY = "channels.history";
	String CHANNELS_INFO = "channels.info";
	String CHANNELS_INVITE = "channels.invite";
	String CHANNELS_JOIN = "channels.join";
	String CHANNELS_KICK = "channels.kick";
	String CHANNELS_LEAVE = "channels.leave";
	String CHANNELS_LIST = "channels.list";
	String CHANNELS_MARK = "channels.mark";
	String CHANNELS_RENAME = "channels.rename";
	String CHANNELS_SET_PURPOSE = "channels.setPurpose";
	String CHANNELS_SET_TOPIC = "channels.setTopic";
	String CHANNELS_UNARCHIVE = "channels.unarchive";

	// chat

	String CHAT_DELETE = "chat.delete";
	String CHAT_ME_MESSAGE = "chat.meMessage";
	String CHAT_POST_MESSAGE = "chat.postMessage";
	String CHAT_UPDATE = "chat.update";

	// dnd
	String DND_END_DND = "dnd.endDnd";
	String DND_END_SNOOZE = "dnd.endSnooze";
	String DND_INFO = "dnd.info";
	String DND_SET_SNOOZE = "dnd.setSnooze";
	String DND_TEAM_INFO = "dnd.teamInfo";

	// emoji

	String EMOJI_LIST = "emoji.list";

	// files.comments

	String FILES_COMMENTS_ADD = "files.comments.add";
	String FILES_COMMENTS_DELETE = "files.comments.delete";
	String FILES_COMMENTS_EDIT = "files.comments.edit";

	// files

	String FILES_DELETE = "files.delete";
	String FILES_INFO = "files.info";
	String FILES_LIST = "files.list";
	String FILES_REVOKE_PUBLIC_URL = "files.revokePublicURL";
	String FILES_SHARED_PUBLIC_URL = "files.sharedPublicURL";
	String FILES_UPLOAD = "files.upload";

	// group

	String GROUPS_ARCHIVE = "groups.archive";
	String GROUPS_CLOSE = "groups.close";
	String GROUPS_CREATE = "groups.create";
	String GROUPS_CREATE_CHILD = "groups.createChild";
	String GROUPS_HISTORY = "groups.history";
	String GROUPS_INFO = "groups.info";
	String GROUPS_INVITE = "groups.invite";
	String GROUPS_KICK = "groups.kick";
	String GROUPS_LEAVE = "groups.leave";
	String GROUPS_LIST = "groups.list";
	String GROUPS_MARK = "groups.mark";
	String GROUPS_OPEN = "groups.open";
	String GROUPS_RENAME = "groups.rename";
	String GROUPS_SET_PURPOSE = "groups.setPurpose";
	String GROUPS_SET_TOPIC = "groups.setTopic";
	String GROUPS_UNARCHIVE = "groups.unarchive";

	// im (direct message channel)

	String IM_CLOSE = "im.close";
	String IM_HISTORY = "im.history";
	String IM_LIST = "im.list";
	String IM_MARK = "im.mark";
	String IM_OPEN = "im.open";

	// mipm

	String MPIM_CLOSE = "mpim.close";
	String MPIM_HISTORY = "mpim.history";
	String MPIM_LIST = "mpim.list";
	String MPIM_MARK = "mpim.mark";
	String MPIM_OPEN = "mpim.open";

	// oauth

	String OAUTH_ACCESS = "oauth.access";

	// pins

	String PINS_ADD = "pins.add";
	String PINS_LIST = "pins.list";
	String PINS_REMOVE = "pins.remove";

	// reactions

	String REACTIONS_ADD = "reactions.add";
	String REACTIONS_GET = "reactions.get";
	String REACTIONS_LIST = "reactions.list";
	String REACTIONS_REMOVE = "reactions.remove";


	// reminders

	String REMINDERS_ADD = "reminders.add";
	String REMINDERS_COMPLETE = "reminders.complete";
	String REMINDERS_DELETE = "reminders.delete";
	String REMINDERS_INFO = "reminders.info";
	String REMINDERS_LIST = "reminders.list";


	// rtm

	String RTM_START = "rtm.start";

	// search

	String SEARCH_ALL = "search.all";
	String SEARCH_FILES = "search.files";
	String SEARCH_MESSAGES = "search.messages";

	// stars

	String STARS_ADD = "stars.add";
	String STARS_LIST = "stars.list";
	String STARS_REMOVE = "stars.remove";

	// team

	String TEAM_ACCESS_LOGS = "team.accessLogs";
	String TEAM_INFO = "team.info";
	String TEAM_INTEGRATION_LOGS = "team.integrationLogs";

	// team profile

	String TEAM_PROFILE_GET = "team.profile.get";

	// usergroups

	String USERGROUPS_CREATE = "usergroups.create";
	String USERGROUPS_DISABLE = "usergroups.disable";
	String USERGROUPS_ENABLE = "usergroups.enable";
	String USERGROUPS_LIST = "usergroups.list";
	String USERGROUPS_UPDATE = "usergroups.update";

	// usergroups.users

	String USERGROUPS_USERS_LIST = "usergroups.users.list";
	String USERGROUPS_USERS_UPDATE = "usergroups.users.update";

	// users

	String USERS_GET_PRESENCE = "users.getPresence";
	String USERS_INFO = "users.info";
	String USERS_LIST = "users.list";
	String USERS_SET_ACTIVE = "users.setActive";
	String USERS_SET_PRESENCE = "users.setPresence";

	// users.profile

	String USERS_PROFILE_GET = "users.profile.get";
	String USERS_PROFILE_SET = "users.profile.set";

}
