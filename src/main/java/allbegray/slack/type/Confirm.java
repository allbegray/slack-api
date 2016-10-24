package allbegray.slack.type;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by allbegray on 2016-10-24.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Confirm {

    protected String title;
    protected String text;
    protected String ok_text;
    protected String dismiss_text;

    public Confirm() {
    }

    public Confirm(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getOk_text() {
        return ok_text;
    }

    public void setOk_text(String ok_text) {
        this.ok_text = ok_text;
    }

    public String getDismiss_text() {
        return dismiss_text;
    }

    public void setDismiss_text(String dismiss_text) {
        this.dismiss_text = dismiss_text;
    }

}
