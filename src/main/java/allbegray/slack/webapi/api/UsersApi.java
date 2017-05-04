package allbegray.slack.webapi.api;

import java.util.List;

import allbegray.slack.type.Presence;
import allbegray.slack.type.User;
import allbegray.slack.type.UserPresence;

public interface UsersApi {

    UserPresence getUserPresence(String user);

    User getUserInfo(String user);

    List<User> getUserList();

    List<User> getUserListWithPresence();

    boolean setActiveUser();

    boolean setPresenceUser(Presence presence);

}
