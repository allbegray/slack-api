package flowctrl.integration.slack.type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReminderList {

    protected List<Reminder> reminders;


    public List<Reminder> getReminders() {
        return reminders;
    }


    public void setReminders(List<Reminder> reminders) {
        this.reminders = reminders;
    }


    @Override
    public String toString() {
        return "ReminderList{" +
                "reminders=" + reminders +
                '}';
    }
}