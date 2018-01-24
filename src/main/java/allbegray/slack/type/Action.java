package allbegray.slack.type;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by allbegray on 2016-10-24.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Action {

    enum Style {
        primary, danger
    }

    public Action() {
    }

    public Action(String text, String value) {
        this("generic_name", text, "button");

        // if value is not set, let it be the same as the button's text
        this.value = (value == null ? text : value);
    }

    public Action(String name, String text, String type) {
        this.name = name;
        this.text = text;
        this.type = type;
    }

    protected String name;
    protected String text;
    protected String type;
    protected String value;
    protected String url;

    protected Style style;
    protected Confirm confirm;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    public void setStyle(String style) {
        if (style != null && !style.isEmpty()) {
            try {
                this.style = Style.valueOf(style);
            } catch (IllegalArgumentException e) {
                this.style = null;
            }
        }
    }

    public Confirm getConfirm() {
        return confirm;
    }

    public void setConfirm(Confirm confirm) {
        this.confirm = confirm;
    }

    @Override
    public String toString() {
        return "Action [text=" + text + ", type=" + type + ", name=" + name + ", value=" + this.value + ", url=" + this.url + "]";
    }
}
