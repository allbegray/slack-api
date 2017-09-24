package allbegray.slack.webapi.api;

import java.util.List;
import java.util.Map;

import allbegray.slack.type.Attachment;
import allbegray.slack.webapi.method.chats.ChatPostMessageMethod;

public interface ChatApi {

    boolean deleteMessage(String channel, String ts);

    boolean meMessage(String channel, String text);

    String postMessage(String channel, String text);

    String postMessage(String channel, String text, String username, boolean as_user);

    String postMessage(String channel, String text, String username, boolean as_user, boolean link_names,
        List<Attachment> attachments, boolean unfurl_links, boolean unfurl_media, String icon_url,
        String icon_emoji);

    String postMessage(ChatPostMessageMethod method);

    String updateMessage(String channel, String ts, String text);

    String updateMessage(String channel, String ts, String text, List<Attachment> attachments, boolean link_names);

    String unfurl(String channel, String ts, Map<String, Attachment> unfurlResponseMap, boolean user_auth_required);
}
