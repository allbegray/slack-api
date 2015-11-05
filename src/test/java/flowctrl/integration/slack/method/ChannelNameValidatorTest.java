package flowctrl.integration.slack.method;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Assert;
import org.junit.Test;

import flowctrl.integration.slack.validation.ChannelNameValidator;

public class ChannelNameValidatorTest {

	@Test
	public void channelNameValidatorTest() {

		Map<String, Boolean> words = new HashMap<String, Boolean>();
		words.put(null, false);
		words.put("한글", false);
		words.put("", false);
		words.put("A", false);
		words.put("abcA", false);
		words.put("-", false);
		words.put("_", false);
		words.put("a0-G", false);
		words.put("1234567890123456789012", false);

		words.put("archive", false);
		words.put("deleted-channel", false);
		words.put("everyone", false);
		words.put("group", false);
		words.put("create", false);
		words.put("channel", false);

		words.put("090", true);
		words.put("uenginesoft", true);
		words.put("flowctrl", true);
		words.put("dev", true);
		words.put("project_nicehop", true);
		words.put("a", true);
		words.put("0-0_", true);

		for (Entry<String, Boolean> entry : words.entrySet()) {
			boolean ok = ChannelNameValidator.valid(entry.getKey());
			Assert.assertTrue(ok == entry.getValue());
		}

	}

}
