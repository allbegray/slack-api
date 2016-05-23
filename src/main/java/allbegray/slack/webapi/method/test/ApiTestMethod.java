package allbegray.slack.webapi.method.test;

import java.util.List;
import java.util.Map;

import allbegray.slack.validation.ValidationError;
import allbegray.slack.webapi.SlackWebApiConstants;
import allbegray.slack.webapi.method.AbstractMethod;

public class ApiTestMethod extends AbstractMethod {

	public ApiTestMethod() {
	}

	public ApiTestMethod(String foo, String error) {
		this.foo = foo;
		this.error = error;
	}

	protected String foo;
	protected String error;

	public String getFoo() {
		return foo;
	}

	public void setFoo(String foo) {
		this.foo = foo;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	@Override
	public boolean isRequiredToken() {
		return false;
	}

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.API_TEST;
	}

	@Override
	public void validate(List<ValidationError> errors) {
		// ignore
	}

	@Override
	protected void createParameters(Map<String, String> parameters) {
		parameters.put("foo", foo);
		if (error != null) {
			parameters.put("error", error);
		}
	}

}
