package allbegray.slack.webapi.api;

import allbegray.slack.type.ReminderInfo;
import allbegray.slack.type.ReminderList;

public interface RemindersApi {

    boolean addReminder(String text, String time);

    boolean addReminder(String text, long time);

    boolean completeReminder(String reminderId);

    boolean deleteReminder(String reminderId);

    ReminderInfo getReminderInfo(String reminderId);

    ReminderList getReminderList();
}
