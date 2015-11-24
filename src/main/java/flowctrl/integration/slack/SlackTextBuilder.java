package flowctrl.integration.slack;

public class SlackTextBuilder {

	private StringBuffer buffer = new StringBuffer();

	public static SlackTextBuilder create() {
		return new SlackTextBuilder();
	}

	protected SlackTextBuilder() {
	}

	public SlackTextBuilder text(String text) {
		buffer.append(text);
		return this;
	}

	public SlackTextBuilder mail(String email) {
		return mail(email, null);
	}

	public SlackTextBuilder mail(String email, String text) {
		return link("mailto:" + email, text);
	}

	public SlackTextBuilder link(String url) {
		return link(url, null);
	}

	public SlackTextBuilder link(String url, String text) {
		if (text != null && text.length() > 0) {
			buffer.append("<").append(url).append("|").append(text).append(">");
		} else {
			buffer.append("<").append(url).append(">");
		}
		return this;
	}

	public SlackTextBuilder bold(String text) {
		buffer.append(" *").append(text).append("*");
		return this;
	}

	public SlackTextBuilder italic(String text) {
		buffer.append(" _").append(text).append("_");
		return this;
	}

	public SlackTextBuilder strike(String text) {
		buffer.append(" ~").append(text).append("~");
		return this;
	}

	public SlackTextBuilder code(String code) {
		buffer.append("`").append(code).append("`");
		return this;
	}

	public SlackTextBuilder preformatted(String text) {
		buffer.append("\n```").append(text).append("```");
		return this;
	}

	public SlackTextBuilder quote(String text) {
		buffer.append("\n> ").append(text).append("\n");
		return this;
	}
	
	public SlackTextBuilder paragraph(String text) {
		buffer.append("\n>>> ").append(text).append("\n");
		return this;
	}

	public SlackTextBuilder newline() {
		buffer.append("\n");
		return this;
	}

	public String build() {
		return buffer.length() > 0 ? buffer.toString() : null;
	}

}
