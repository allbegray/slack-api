package allbegray.slack.webapi.api;

import java.util.List;

import allbegray.slack.type.Group;
import allbegray.slack.type.History;

public interface GroupsApi {

    boolean archiveGroup(String channel);

    boolean closeGroup(String channel);

    Group createGroup(String name);

    Group createChildGroup(String name);

    History getGroupHistory(String channel);

    History getGroupHistory(String channel, int count);

    History getGroupHistory(String channel, String latest, String oldest, boolean inclusive, int count, boolean unreads);

    Group getGroupInfo(String channel);

    Group inviteUserToGroup(String channel, String user);

    boolean kickUserFromGroup(String channel, String user);

    boolean leaveGroup(String channel);

    List<Group> getGroupList();

    List<Group> getGroupList(boolean exclude_archived);

    boolean markGroup(String channel, String ts);

    boolean openGroup(String channel);

    Group renameGroup(String channel, String name);

    boolean setGroupPurpose(String channel, String purpose);

    boolean setGroupTopic(String channel, String topic);

    boolean unarchiveGroup(String channel);
}
