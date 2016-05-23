package allbegray.slack.type;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class File {

	protected String id;
	protected Long created;
	protected Long timestamp;

	protected String name;
	protected String title;
	protected String mimetype;
	protected String filetype;
	protected String pretty_type;
	protected String user;

	protected String mode;
	protected Boolean editable;
	protected Boolean is_external;
	protected String external_type;

	protected Integer size;

	protected String url;
	protected String url_download;
	protected String url_private;
	protected String url_private_download;

	protected String thumb_64;
	protected String thumb_80;
	protected String thumb_360;
	protected String thumb_360_gif;
	protected String thumb_360_w;
	protected String thumb_360_h;
	protected Integer image_exif_rotation;
	protected Integer original_w;
	protected Integer original_h;

	protected String permalink;
	protected String permalink_public;
	protected String edit_link;
	protected String preview;
	protected String preview_highlight;
	protected Integer lines;
	protected Integer lines_more;

	protected Boolean is_public;
	protected Boolean public_url_shared;
	protected List<String> channels;
	protected List<String> groups;
	protected List<String> ims;
	protected Integer comments_count;
	protected Comment initial_comment;
	protected Integer num_stars;
	protected Boolean is_starred;
	protected List<String> pinned_to;
	protected List<Reaction> reactions;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getCreated() {
		return created;
	}

	public void setCreated(Long created) {
		this.created = created;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMimetype() {
		return mimetype;
	}

	public void setMimetype(String mimetype) {
		this.mimetype = mimetype;
	}

	public String getFiletype() {
		return filetype;
	}

	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}

	public String getPretty_type() {
		return pretty_type;
	}

	public void setPretty_type(String pretty_type) {
		this.pretty_type = pretty_type;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public Boolean getEditable() {
		return editable;
	}

	public void setEditable(Boolean editable) {
		this.editable = editable;
	}

	public Boolean getIs_external() {
		return is_external;
	}

	public void setIs_external(Boolean is_external) {
		this.is_external = is_external;
	}

	public String getExternal_type() {
		return external_type;
	}

	public void setExternal_type(String external_type) {
		this.external_type = external_type;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrl_download() {
		return url_download;
	}

	public void setUrl_download(String url_download) {
		this.url_download = url_download;
	}

	public String getUrl_private() {
		return url_private;
	}

	public void setUrl_private(String url_private) {
		this.url_private = url_private;
	}

	public String getUrl_private_download() {
		return url_private_download;
	}

	public void setUrl_private_download(String url_private_download) {
		this.url_private_download = url_private_download;
	}

	public String getThumb_64() {
		return thumb_64;
	}

	public void setThumb_64(String thumb_64) {
		this.thumb_64 = thumb_64;
	}

	public String getThumb_80() {
		return thumb_80;
	}

	public void setThumb_80(String thumb_80) {
		this.thumb_80 = thumb_80;
	}

	public String getThumb_360() {
		return thumb_360;
	}

	public void setThumb_360(String thumb_360) {
		this.thumb_360 = thumb_360;
	}

	public String getThumb_360_gif() {
		return thumb_360_gif;
	}

	public void setThumb_360_gif(String thumb_360_gif) {
		this.thumb_360_gif = thumb_360_gif;
	}

	public String getThumb_360_w() {
		return thumb_360_w;
	}

	public void setThumb_360_w(String thumb_360_w) {
		this.thumb_360_w = thumb_360_w;
	}

	public String getThumb_360_h() {
		return thumb_360_h;
	}

	public void setThumb_360_h(String thumb_360_h) {
		this.thumb_360_h = thumb_360_h;
	}

	public Integer getImage_exif_rotation() {
		return image_exif_rotation;
	}

	public void setImage_exif_rotation(Integer image_exif_rotation) {
		this.image_exif_rotation = image_exif_rotation;
	}

	public Integer getOriginal_w() {
		return original_w;
	}

	public void setOriginal_w(Integer original_w) {
		this.original_w = original_w;
	}

	public Integer getOriginal_h() {
		return original_h;
	}

	public void setOriginal_h(Integer original_h) {
		this.original_h = original_h;
	}

	public String getPermalink() {
		return permalink;
	}

	public void setPermalink(String permalink) {
		this.permalink = permalink;
	}

	public String getPermalink_public() {
		return permalink_public;
	}

	public void setPermalink_public(String permalink_public) {
		this.permalink_public = permalink_public;
	}

	public String getEdit_link() {
		return edit_link;
	}

	public void setEdit_link(String edit_link) {
		this.edit_link = edit_link;
	}

	public String getPreview() {
		return preview;
	}

	public void setPreview(String preview) {
		this.preview = preview;
	}

	public String getPreview_highlight() {
		return preview_highlight;
	}

	public void setPreview_highlight(String preview_highlight) {
		this.preview_highlight = preview_highlight;
	}

	public Integer getLines() {
		return lines;
	}

	public void setLines(Integer lines) {
		this.lines = lines;
	}

	public Integer getLines_more() {
		return lines_more;
	}

	public void setLines_more(Integer lines_more) {
		this.lines_more = lines_more;
	}

	public Boolean getIs_public() {
		return is_public;
	}

	public void setIs_public(Boolean is_public) {
		this.is_public = is_public;
	}

	public Boolean getPublic_url_shared() {
		return public_url_shared;
	}

	public void setPublic_url_shared(Boolean public_url_shared) {
		this.public_url_shared = public_url_shared;
	}

	public List<String> getChannels() {
		if (channels == null) {
			channels = new ArrayList<String>();
		}
		return channels;
	}

	public void setChannels(List<String> channels) {
		this.channels = channels;
	}

	public List<String> getGroups() {
		if (groups == null) {
			groups = new ArrayList<String>();
		}
		return groups;
	}

	public void setGroups(List<String> groups) {
		this.groups = groups;
	}

	public List<String> getIms() {
		if (ims == null) {
			ims = new ArrayList<String>();
		}
		return ims;
	}

	public void setIms(List<String> ims) {
		this.ims = ims;
	}

	public Integer getComments_count() {
		return comments_count;
	}

	public void setComments_count(Integer comments_count) {
		this.comments_count = comments_count;
	}

	public Comment getInitial_comment() {
		return initial_comment;
	}

	public void setInitial_comment(Comment initial_comment) {
		this.initial_comment = initial_comment;
	}

	public Integer getNum_stars() {
		return num_stars;
	}

	public void setNum_stars(Integer num_stars) {
		this.num_stars = num_stars;
	}

	public Boolean getIs_starred() {
		return is_starred;
	}

	public void setIs_starred(Boolean is_starred) {
		this.is_starred = is_starred;
	}

	public List<String> getPinned_to() {
		if (pinned_to == null) {
			pinned_to = new ArrayList<String>();
		}
		return pinned_to;
	}

	public void setPinned_to(List<String> pinned_to) {
		this.pinned_to = pinned_to;
	}

	public List<Reaction> getReactions() {
		return reactions;
	}

	public void setReactions(List<Reaction> reactions) {
		this.reactions = reactions;
	}

	@Override
	public String toString() {
		return "File [id=" + id + ", created=" + created + ", timestamp=" + timestamp + ", name=" + name + ", title=" + title + ", mimetype=" + mimetype + ", filetype=" + filetype + ", pretty_type="
				+ pretty_type + ", user=" + user + ", mode=" + mode + ", editable=" + editable + ", is_external=" + is_external + ", external_type=" + external_type + ", size=" + size + ", url=" + url
				+ ", url_download=" + url_download + ", url_private=" + url_private + ", url_private_download=" + url_private_download + ", thumb_64=" + thumb_64 + ", thumb_80=" + thumb_80
				+ ", thumb_360=" + thumb_360 + ", thumb_360_gif=" + thumb_360_gif + ", thumb_360_w=" + thumb_360_w + ", thumb_360_h=" + thumb_360_h + ", image_exif_rotation=" + image_exif_rotation
				+ ", original_w=" + original_w + ", original_h=" + original_h + ", permalink=" + permalink + ", permalink_public=" + permalink_public + ", edit_link=" + edit_link + ", preview="
				+ preview + ", preview_highlight=" + preview_highlight + ", lines=" + lines + ", lines_more=" + lines_more + ", is_public=" + is_public + ", public_url_shared=" + public_url_shared
				+ ", channels=" + channels + ", groups=" + groups + ", ims=" + ims + ", comments_count=" + comments_count + ", initial_comment=" + initial_comment + ", num_stars=" + num_stars
				+ ", is_starred=" + is_starred + ", pinned_to=" + pinned_to + ", reactions=" + reactions + "]";
	}

}
