package allbegray.slack.webapi.api;

import allbegray.slack.type.ReactionItem;
import allbegray.slack.type.ReactionList;

public interface ReactionsApi {

    boolean addReactionToFile(String emojiName, String file);

    boolean addReactionToFileComment(String emojiName, String file_comment);

    boolean addReactionToMessage(String emojiName, String channel, String timestamp);

    ReactionItem getReactionByFile(String emojiName, String file);

    ReactionItem getReactionByFileComment(String emojiName, String file_comment);

    ReactionItem getReactionByMessage(String emojiName, String channel, String timestamp);

    ReactionList getReactionList(int page);

    ReactionList getReactionList(int page, int count);

    ReactionList getReactionList(String user, int page);

    ReactionList getReactionList(String user, int page, int count);

    boolean removeReactionFromFile(String emojiName, String file);

    boolean removeReactionFromFileComment(String emojiName, String file_comment);

    boolean removeReactionFromMessage(String emojiName, String channel, String timestamp);
}
