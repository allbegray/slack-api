package flowctrl.integration.slack;

import org.junit.Assert;
import org.junit.Test;

public class SlackSearchQueryBuilderTest {
	
	@Test
	public void textTest() {
		String query = "test message in:#dev";
		String retQuery = SlackSearchQueryBuilder.create().text(query).build();
		
		Assert.assertTrue(query.equals(retQuery));
	}
	
	@Test
	public void textTrimTest() {
		String query = " test message in:#dev ";
		String retQuery = SlackSearchQueryBuilder.create().text(query).build();
		
		Assert.assertTrue(query.trim().equals(retQuery));
	}
	
	@Test
	public void inTest() {
		String query = SlackSearchQueryBuilder.create()
				.in("test")
				.inUserName("allbegray")
				.inChannelName("general")
				.build();
		
		Assert.assertTrue(query.equals("in:test in:@allbegray in:#general"));
	}
	
	@Test
	public void fromTest() {
		String query = SlackSearchQueryBuilder.create()
				.from("k1005")
				.fromMe()
				.fromUserName("allbegray")
				.build();
		
		Assert.assertTrue(query.equals("from:k1005 from:me from:@allbegray"));
	}
	
	@Test
	public void hasTest() {
		String query = SlackSearchQueryBuilder.create()
				.hasEmoji("ghost")
				.hasEmoji(":smile:")
				.hasEmoji(":blush")
				.hasEmoji("smiley:")
				.hasLink()
				.hasReaction()
				.hasStar()
				.build();
		
		Assert.assertTrue(query.equals("has::ghost: has::smile: has::blush: has::smiley: has:link has:reaction has:star"));
	}
	
	@Test
	public void dateAndTimeTest() {
		String query = SlackSearchQueryBuilder.create()
				.before(SlackDateTime.YEAR)
				.before("today")
				.before("2015-11-25")
				.build();
				
		Assert.assertTrue(query.equals("before:year before:today before:2015-11-25"));
				
		query = SlackSearchQueryBuilder.create()
				.after(SlackDateTime.MONTH)
				.after("week")
				.after("2014-01-01")
				.build();
		
		Assert.assertTrue(query.equals("after:month after:week after:2014-01-01"));
		
		query = SlackSearchQueryBuilder.create()
				.on(SlackDateTime.NOVEMBER)
				.on("february")
				.on("2015-11-01")
				.build();
		
		Assert.assertTrue(query.equals("on:november on:february on:2015-11-01"));
		
		query = SlackSearchQueryBuilder.create()
				.during(SlackDateTime.YESTERDAY)
				.during("friday")
				.during("1984-02-09")
				.build();
		
		Assert.assertTrue(query.equals("during:yesterday during:friday during:1984-02-09"));
	}
	
	@Test
	public void complexTest() {
		String query1 = SlackSearchQueryBuilder.create().inChannelName("general").fromMe().after(SlackDateTime.YESTERDAY).build();
		Assert.assertTrue(query1.equals("in:#general from:me after:yesterday"));
		
		String query2 = SlackSearchQueryBuilder.create().inUserName("allbegray").fromUserName("k1005").hasLink().build();
		Assert.assertTrue(query2.equals("in:@allbegray from:@k1005 has:link"));
		
		String query3 = SlackSearchQueryBuilder.create().in("@allbegray").from("@k1005").hasReaction().hasEmoji("ghost").build();
		Assert.assertTrue(query3.equals("in:@allbegray from:@k1005 has:reaction has::ghost:"));
		
		String query4 = SlackSearchQueryBuilder.create().text(" test message ").before("today").text(" test commit ").build();
		Assert.assertTrue(query4.equals("test message before:today test commit"));
	}
	
}
