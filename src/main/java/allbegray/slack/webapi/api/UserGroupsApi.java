package allbegray.slack.webapi.api;

import java.util.List;

import allbegray.slack.type.Usergroup;

public interface UserGroupsApi {

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

    List<String> getUsergroupUserList(String usergroup);

    List<String> getUsergroupUserList(String usergroup, boolean include_disabled);

    Usergroup updateUsergroupUser(String usergroup, List<String> users);

    Usergroup updateUsergroupUser(String usergroup, List<String> users, boolean include_count);
}
