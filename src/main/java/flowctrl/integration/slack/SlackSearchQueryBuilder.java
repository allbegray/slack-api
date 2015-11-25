package flowctrl.integration.slack;

public class SlackSearchQueryBuilder {

	private static final String FILTER_IN = "in";
	private static final String FILTER_FROM = "from";

	private static final String FILTER_HAS = "has";

	private static final String FILTER_BEFORE = "before";
	private static final String FILTER_AFTER = "after";
	private static final String FILTER_ON = "on";
	private static final String FILTER_DURING = "during";

	private StringBuffer buffer = new StringBuffer();
	private boolean usingFilter;

	public static SlackSearchQueryBuilder create() {
		return new SlackSearchQueryBuilder();
	}

	protected SlackSearchQueryBuilder() {
	}

	public SlackSearchQueryBuilder text(String text) {
		if (text == null) {
			return this;
		}

		text = text.trim();

		if (text.length() == 0) {
			return this;
		}

		if (usingFilter) {
			buffer.append(" ");
		}
		buffer.append(text);
		usingFilter = false;
		return this;
	}

	public SlackSearchQueryBuilder in(String text) {
		return filter(FILTER_IN, text);
	}

	public SlackSearchQueryBuilder inChannelName(String channelName) {
		if (channelName != null) {
			channelName = channelName.trim();
			channelName = "#" + channelName;
		}
		return filter(FILTER_IN, channelName);
	}

	public SlackSearchQueryBuilder inUserName(String userName) {
		if (userName != null) {
			userName = userName.trim();
			userName = "@" + userName;
		}
		return filter(FILTER_IN, userName);
	}

	public SlackSearchQueryBuilder from(String text) {
		return filter(FILTER_FROM, text);
	}

	public SlackSearchQueryBuilder fromUserName(String userName) {
		if (userName != null) {
			userName = userName.trim();
			userName = "@" + userName;
		}
		return filter(FILTER_FROM, userName);
	}

	public SlackSearchQueryBuilder fromMe() {
		return filter(FILTER_FROM, "me");
	}

	public SlackSearchQueryBuilder hasLink() {
		return filter(FILTER_HAS, "link");
	}

	public SlackSearchQueryBuilder hasStar() {
		return filter(FILTER_HAS, "star");
	}

	public SlackSearchQueryBuilder hasReaction() {
		return filter(FILTER_HAS, "reaction");
	}

	public SlackSearchQueryBuilder hasEmoji(String emojiName) {
		if (emojiName != null) {
			emojiName = emojiName.trim();
			if (!emojiName.startsWith(":")) {
				emojiName = ":" + emojiName;	
			}
			if (!emojiName.endsWith(":")) {
				emojiName = emojiName + ":";	
			}
		}
		return filter(FILTER_HAS, emojiName);
	}

	public SlackSearchQueryBuilder before(String date) {
		return filter(FILTER_BEFORE, date);
	}

	public SlackSearchQueryBuilder before(SlackDateTime dateTime) {
		before(dateTime.name().toLowerCase());
		return this;
	}

	public SlackSearchQueryBuilder after(String date) {
		return filter(FILTER_AFTER, date);
	}

	public SlackSearchQueryBuilder after(SlackDateTime dateTime) {
		after(dateTime.name().toLowerCase());
		return this;
	}

	public SlackSearchQueryBuilder on(String date) {
		return filter(FILTER_ON, date);
	}

	public SlackSearchQueryBuilder on(SlackDateTime dateTime) {
		on(dateTime.name().toLowerCase());
		return this;
	}

	public SlackSearchQueryBuilder during(String date) {
		return filter(FILTER_DURING, date);
	}

	public SlackSearchQueryBuilder during(SlackDateTime dateTime) {
		during(dateTime.name().toLowerCase());
		return this;
	}

	protected SlackSearchQueryBuilder filter(String prefix, String text) {
		if (text == null) {
			return this;
		}

		if (buffer.length() > 0) {
			buffer.append(" ");
		}
		buffer.append(prefix + ":" + text.trim());
		usingFilter = true;
		return this;
	}

	public String build() {
		return buffer.length() > 0 ? buffer.toString() : null;
	}

}
