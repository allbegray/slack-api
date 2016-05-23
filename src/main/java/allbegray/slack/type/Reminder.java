package allbegray.slack.type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Reminder {


    protected String id;
    protected String creator;
    protected String user;
    protected String text;
    protected boolean recurring;
    protected long time;
    protected long complete_ts;


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public String getCreator() {
        return creator;
    }


    public void setCreator(String creator) {
        this.creator = creator;
    }


    public String getUser() {
        return user;
    }


    public void setUser(String user) {
        this.user = user;
    }


    public String getText() {
        return text;
    }


    public void setText(String text) {
        this.text = text;
    }


    public boolean isRecurring() {
        return recurring;
    }


    public void setRecurring(boolean recurring) {
        this.recurring = recurring;
    }


    public long getTime() {
        return time;
    }


    public void setTime(long time) {
        this.time = time;
    }


    public long getComplete_ts() {
        return complete_ts;
    }


    public void setComplete_ts(long complete_ts) {
        this.complete_ts = complete_ts;
    }


    @Override
    public String toString() {
        return "Reminder{" +
                "id='" + id + '\'' +
                ", creator='" + creator + '\'' +
                ", user='" + user + '\'' +
                ", text='" + text + '\'' +
                ", recurring=" + recurring +
                ", time=" + time +
                ", complete_ts=" + complete_ts +
                '}';
    }
}
