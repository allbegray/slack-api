package flowctrl.integration.slack;

public class SlackSearchQueryBuilder {

	private StringBuffer buffer = new StringBuffer();

	public static SlackSearchQueryBuilder create() {
		return new SlackSearchQueryBuilder();
	}

	protected SlackSearchQueryBuilder() {
	}

	public SlackSearchQueryBuilder text(String text) {
		buffer.append(text);
		return this;
	}

	public SlackSearchQueryBuilder inChannelOrUserName(String name) {
		buffer.append(" in:" + name);
		return this;
	}

	public SlackSearchQueryBuilder fromUserName(String userName) {
		buffer.append(" from:" + userName);
		return this;
	}

	public SlackSearchQueryBuilder fromMe() {
		buffer.append(" from:me");
		return this;
	}

	public SlackSearchQueryBuilder hasLink() {
		buffer.append(" has:link");
		return this;
	}

	public SlackSearchQueryBuilder hasLink(String link) {
		buffer.append(" has:" + link);
		return this;
	}

	public SlackSearchQueryBuilder hasStar() {
		buffer.append(" has:star");
		return this;
	}

	public SlackSearchQueryBuilder hasReaction() {
		buffer.append(" has:reaction");
		return this;
	}

	public SlackSearchQueryBuilder hasEmoji(String emojiName) {
		buffer.append(" has::" + emojiName + ":");
		return this;
	}

	public SlackSearchQueryBuilder before(String date) {
		buffer.append(" before:" + date);
		return this;
	}

	public SlackSearchQueryBuilder before(SlackDateTime dateTime) {
		before(dateTime.name().toLowerCase());
		return this;
	}

	public SlackSearchQueryBuilder after(String date) {
		buffer.append(" after:" + date);
		return this;
	}

	public SlackSearchQueryBuilder after(SlackDateTime dateTime) {
		after(dateTime.name().toLowerCase());
		return this;
	}

	public SlackSearchQueryBuilder on(String date) {
		buffer.append(" on:" + date);
		return this;
	}

	public SlackSearchQueryBuilder on(SlackDateTime dateTime) {
		on(dateTime.name().toLowerCase());
		return this;
	}

	public SlackSearchQueryBuilder during(String date) {
		buffer.append(" during:" + date);
		return this;
	}

	public SlackSearchQueryBuilder during(SlackDateTime dateTime) {
		during(dateTime.name().toLowerCase());
		return this;
	}

	public String build() {
		return buffer.length() > 0 ? buffer.toString() : null;
	}

}
