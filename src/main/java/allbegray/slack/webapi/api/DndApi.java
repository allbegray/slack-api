package allbegray.slack.webapi.api;

import java.util.List;
import java.util.Map;

import allbegray.slack.type.DndInfo;
import allbegray.slack.type.DndSimpleInfo;
import allbegray.slack.type.EndSnooze;
import allbegray.slack.type.SetSnooze;

/**
 * do not disturb API
 */
public interface DndApi {

    boolean endDnd();

    EndSnooze endSnooze();

    SetSnooze setSnooze(int num_minutes);

    DndInfo getDndInfo();

    DndInfo getDndInfo(String user);

    Map<String, DndSimpleInfo> getDndTeamInfo();

    Map<String, DndSimpleInfo> getDndTeamInfo(List<String> users);
}
