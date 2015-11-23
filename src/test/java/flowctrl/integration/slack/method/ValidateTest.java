package flowctrl.integration.slack.method;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Assert;
import org.junit.Test;

import flowctrl.integration.slack.validation.Problem;
import flowctrl.integration.slack.validation.SlackFieldValidationUtils;
import flowctrl.integration.slack.validation.ValidationError;
import flowctrl.integration.slack.webapi.method.AbstractHistoryMethod;
import flowctrl.integration.slack.webapi.method.AbstractItemMethod;
import flowctrl.integration.slack.webapi.method.AbstractPagingMethod;
import flowctrl.integration.slack.webapi.method.SlackMethod;
import flowctrl.integration.slack.webapi.method.channels.ChannelHistoryMethod;
import flowctrl.integration.slack.webapi.method.files.FileInfoMethod;
import flowctrl.integration.slack.webapi.method.stars.StarsAddMethod;

public class ValidateTest {
	
	@Test
	public void channelNameValidatorTest() {

		Map<String, Boolean> words = new LinkedHashMap<String, Boolean>();
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
		words.put("archive1", true);
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
		words.put("_test", true);
		words.put("-test", true);

		for (Entry<String, Boolean> entry : words.entrySet()) {
			boolean ok = SlackFieldValidationUtils.validChannelName(entry.getKey());
			if (ok != entry.getValue()) {
				System.out.println("error : " + entry.getKey());
			}
			Assert.assertTrue(ok == entry.getValue());
		}

	}

	@Test
	public void abstractHistoryMethodTest() {
		AbstractHistoryMethod method = new ChannelHistoryMethod(null);
		method.setCount(0);

		validate(method, 2);
	}

	@Test
	public void abstractPagingMethodTest() {
		AbstractPagingMethod method = new FileInfoMethod(null);
		method.setCount(0);
		method.setPage(0);

		validate(method, 3);
	}

	@Test
	public void abstractItemMethodTest() {
		AbstractItemMethod method = new StarsAddMethod();
		validate(method, 1);

		method = new StarsAddMethod();
		method.setTimestamp("123");
		validate(method, 1);

		method = new StarsAddMethod();
		method.setChannel("123");
		validate(method, 1);

		method = new StarsAddMethod();
		method.setChannel("123");
		method.setTimestamp("123");
		validate(method, 0);

		method = new StarsAddMethod();
		method.setFile("123");
		validate(method, 0);

		method = new StarsAddMethod();
		method.setFile_comment("123");
		validate(method, 0);
	}

	private void printError(List<ValidationError> errors) {
		StringBuffer sb = new StringBuffer("*** slack argument error ***");
		for (ValidationError error : errors) {
			if (sb.length() > 0) {
				sb.append("\n");
			}

			if (error.getDescription() != null) {
				sb.append(error.getDescription());
			} else if (error.getProblem() == Problem.REQUIRED) {
				sb.append("\"" + error.getField() + "\" is required.");
			}
		}

		System.out.println(sb.toString());
	}

	private void validate(SlackMethod method, int errorSize) {
		List<ValidationError> errors = new ArrayList<ValidationError>();

		method.validate(errors);

		if (errors.size() > 0) {
			printError(errors);
		}

		Assert.assertTrue(errors.size() == errorSize);
	}

}
