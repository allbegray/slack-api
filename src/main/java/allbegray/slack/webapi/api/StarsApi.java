package allbegray.slack.webapi.api;

import allbegray.slack.type.StarList;

public interface StarsApi {

    boolean addStarToFile(String file);

    boolean addStarToFileComment(String file_comment);

    boolean addStarToMessage(String channel, String timestamp);

    StarList getStarList(int page);

    StarList getStarList(int page, int count);

    StarList getStarList(String user, int page);

    StarList getStarList(String user, int page, int count);

    boolean removeStarFromFile(String file);

    boolean removeStarFromFileComment(String file_comment);

    boolean removeStarFromMessage(String channel, String timestamp);
}
