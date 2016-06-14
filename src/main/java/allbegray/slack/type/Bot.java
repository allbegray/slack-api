package allbegray.slack.type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by allbegray on 2016-06-14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Bot {

    protected String id;
    protected Boolean deleted;
    protected String name;
    protected Icon icons;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * image_36, image_48, image_72
     * @return
     */
    public Icon getIcons() {
        return icons;
    }

    public void setIcons(Icon icons) {
        this.icons = icons;
    }

    @Override
    public String toString() {
        return "Bot{" +
                "id='" + id + '\'' +
                ", deleted=" + deleted +
                ", name='" + name + '\'' +
                ", icons=" + icons +
                '}';
    }

}
