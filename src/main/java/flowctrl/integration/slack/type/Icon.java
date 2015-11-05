package flowctrl.integration.slack.type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Icon {

	protected String image_34;
	protected String image_44;
	protected String image_68;
	protected String image_88;
	protected String image_102;
	protected String image_132;
	protected Boolean image_default;

	public String getImage_34() {
		return image_34;
	}

	public void setImage_34(String image_34) {
		this.image_34 = image_34;
	}

	public String getImage_44() {
		return image_44;
	}

	public void setImage_44(String image_44) {
		this.image_44 = image_44;
	}

	public String getImage_68() {
		return image_68;
	}

	public void setImage_68(String image_68) {
		this.image_68 = image_68;
	}

	public String getImage_88() {
		return image_88;
	}

	public void setImage_88(String image_88) {
		this.image_88 = image_88;
	}

	public String getImage_102() {
		return image_102;
	}

	public void setImage_102(String image_102) {
		this.image_102 = image_102;
	}

	public String getImage_132() {
		return image_132;
	}

	public void setImage_132(String image_132) {
		this.image_132 = image_132;
	}

	public Boolean getImage_default() {
		return image_default;
	}

	public void setImage_default(Boolean image_default) {
		this.image_default = image_default;
	}

	@Override
	public String toString() {
		return "Icon [image_34=" + image_34 + ", image_44=" + image_44 + ", image_68=" + image_68 + ", image_88=" + image_88 + ", image_102=" + image_102 + ", image_132=" + image_132
				+ ", image_default=" + image_default + "]";
	}

}
