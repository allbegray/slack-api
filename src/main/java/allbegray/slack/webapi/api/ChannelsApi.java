package allbegray.slack.webapi.api;

import java.util.List;

import allbegray.slack.type.Channel;
import allbegray.slack.type.History;

public interface ChannelsApi {

    boolean archiveChannel(String channel);

    Channel createChannel(String name);

    History getChannelHistory(String channel);

    History getChannelHistory(String channel, int count);

    History getChannelHistory(String channel, String latest, String oldest, boolean inclusive, int count, boolean unreads);

    Channel getChannelInfo(String channel);

    Channel inviteUserToChannel(String channel, String user);

    Channel joinChannel(String name);

    boolean kickUserFromChannel(String channel, String user);

    boolean leaveChannel(String channel);

    List<Channel> getChannelList();

    List<Channel> getChannelList(boolean exclude_archived);

    boolean markChannel(String channel, String ts);

    Channel renameChannel(String channel, String name);

    boolean setChannelPurpose(String channel, String purpose);

    boolean setChannelTopic(String channel, String topic);

    boolean unarchiveChannel(String channel);

}
