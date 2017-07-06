package allbegray.slack.webapi;

import java.util.Map;

import allbegray.slack.type.Authentication;
import allbegray.slack.type.Bot;
import allbegray.slack.type.OAuthAccessToken;
import allbegray.slack.webapi.api.ChannelsApi;
import allbegray.slack.webapi.api.ChatApi;
import allbegray.slack.webapi.api.DndApi;
import allbegray.slack.webapi.api.FilesApi;
import allbegray.slack.webapi.api.GroupsApi;
import allbegray.slack.webapi.api.ImApi;
import allbegray.slack.webapi.api.MpimApi;
import allbegray.slack.webapi.api.PinsApi;
import allbegray.slack.webapi.api.ReactionsApi;
import allbegray.slack.webapi.api.RemindersApi;
import allbegray.slack.webapi.api.RtmApi;
import allbegray.slack.webapi.api.StarsApi;
import allbegray.slack.webapi.api.TeamApi;
import allbegray.slack.webapi.api.UserGroupsApi;
import allbegray.slack.webapi.api.UsersApi;

public interface SlackWebApiClient extends
    ChannelsApi,
    ChatApi,
    DndApi,
    FilesApi,
    GroupsApi,
    ImApi,
    MpimApi,
    PinsApi,
    ReactionsApi,
    RemindersApi,
    RtmApi,
    StarsApi,
    TeamApi,
    UserGroupsApi,
    UsersApi {

    void shutdown();

    void setWebApiUrl(String webApiUrl);

    String getWebApiUrl();

    Authentication auth();

    Bot getBotInfo(String bot);

    Map<String, String> getEmojiList();

    OAuthAccessToken accessOAuth(String client_id, String client_secret, String code, String redirect_uri);

}
