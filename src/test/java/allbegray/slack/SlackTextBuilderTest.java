package allbegray.slack;

import org.junit.Test;

public class SlackTextBuilderTest {
	
	@Test
	public void basicTest() {
		
		String message = SlackTextBuilder.create()
			.text("text message")
			.newline()
			.link("https://slack.com/")
			.link("https://slack.com", "Slack")
			.newline()
			.bold("bold message")
			.italic("italic message")
			.strike("strike message")
			.newline()
			.mail("test@test.com")
			.mail("test@test.com", "TestMail")
			.newline()
			.code("code block")
			.preformatted("public class SlackWebhookClientTest() {\n\n\tpublic static void main(String args[]) {\n\n\t}\n}")
			.quote("quote message")
			.build();
		
		System.out.println(message);
	}
	
}	
