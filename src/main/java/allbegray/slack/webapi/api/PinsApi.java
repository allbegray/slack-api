package allbegray.slack.webapi.api;

import java.util.List;

import allbegray.slack.type.PinItem;

public interface PinsApi {

    boolean pinFile(String channel, String file);

    boolean pinFileComment(String channel, String file_comment);

    boolean pinMessage(String channel, String timestamp);

    List<PinItem> getPinList(String channel);

    boolean unpinFile(String channel, String file);

    boolean unpinFileComment(String channel, String file_comment);

    boolean unpinMessage(String channel, String timestamp);
}
