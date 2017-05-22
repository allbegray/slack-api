package allbegray.slack.webapi.api;

import java.util.List;

import allbegray.slack.type.DirectMessageChannel;
import allbegray.slack.type.History;

/**
 * direct message channel API
 */
public interface ImApi {

    boolean closeDirectMessageChannel(String channel);

    History getDirectMessageChannelHistory(String channel);

    History getDirectMessageChannelHistory(String channel, int count);

    History getDirectMessageChannelHistory(String channel, String latest, String oldest, boolean inclusive, int count,
        boolean unreads);

    List<DirectMessageChannel> getDirectMessageChannelList();

    boolean markDirectMessageChannel(String channel, String ts);

    String openDirectMessageChannel(String user);
}
