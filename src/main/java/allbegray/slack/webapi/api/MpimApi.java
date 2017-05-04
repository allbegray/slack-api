package allbegray.slack.webapi.api;

import java.util.List;

import allbegray.slack.type.Group;
import allbegray.slack.type.History;

/**
 * multiparty direct message channel
 */
public interface MpimApi {

    boolean closeMultipartyDirectMessageChannel(String channel);

    History getMultipartyDirectMessageChannelHistory(String channel);

    History getMultipartyDirectMessageChannelHistory(String channel, int count);

    History getMultipartyDirectMessageChannelHistory(String channel, String latest, String oldest, boolean inclusive, int count,
        boolean unreads);

    List<Group> getMultipartyDirectMessageChannelList();

    boolean markMultipartyDirectMessageChannel(String channel, String ts);

    Group openMultipartyDirectMessageChannel(String... users);

    Group openMultipartyDirectMessageChannel(List<String> users);
}
