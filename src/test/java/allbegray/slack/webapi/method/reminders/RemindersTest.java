package allbegray.slack.webapi.method.reminders;

import allbegray.slack.SlackClientFactory;
import allbegray.slack.type.Reminder;
import allbegray.slack.type.ReminderInfo;
import allbegray.slack.type.ReminderList;
import allbegray.slack.webapi.SlackWebApiClient;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

@Ignore
public class RemindersTest {

    private SlackWebApiClient webApiClient;


    @Before
    public void setUp() throws Exception {
        String token = System.getenv().get("auth_token");
        assertNotNull(token);

        webApiClient = SlackClientFactory.createWebApiClient(token, token);
    }


    @Test
    public void test() throws Exception {
        // get count before
        ReminderList reminderListStart = webApiClient.getReminderList();
        int countStart = reminderListStart.getReminders().size();

        // add one
        assertTrue(webApiClient.addReminder("something", "in 5 minutes"));

        // assert one was added
        ReminderList reminderListAfterAdd = webApiClient.getReminderList();
        int countAfterAdd = reminderListAfterAdd.getReminders().size();
        assertEquals(countStart + 1, countAfterAdd);

        String reminderId = reminderListAfterAdd.getReminders().get(0).getId();

        // info
        ReminderInfo reminderInfo = webApiClient.getReminderInfo(reminderId);
        Reminder reminder = reminderInfo.getReminder();
        assertNotNull(reminder);
        // TODO assert not complete

        // complete
        assertTrue(webApiClient.completeReminder(reminderId));
        // TODO assert complete now

        // delete
        assertTrue(webApiClient.deleteReminder(reminderId));

        // assert one was removed
        ReminderList reminderListAfterDelete = webApiClient.getReminderList();
        int countAfterDelete = reminderListAfterDelete.getReminders().size();
        assertEquals(countStart, countAfterDelete);

    }


}