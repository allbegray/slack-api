package allbegray.slack.webapi.method.rtm;

import java.util.List;
import java.util.Map;

import allbegray.slack.validation.ValidationError;
import allbegray.slack.webapi.SlackWebApiConstants;
import allbegray.slack.webapi.method.AbstractMethod;

public class RtmStartMethod extends AbstractMethod {

	protected String simple_latest;
	protected String no_unreads;
	protected String mpim_aware;

	public String getSimple_latest() {
		return simple_latest;
	}

	public void setSimple_latest(String simple_latest) {
		this.simple_latest = simple_latest;
	}

	public String getNo_unreads() {
		return no_unreads;
	}

	public void setNo_unreads(String no_unreads) {
		this.no_unreads = no_unreads;
	}

	public String getMpim_aware() {
		return mpim_aware;
	}

	public void setMpim_aware(String mpim_aware) {
		this.mpim_aware = mpim_aware;
	}

	@Override
	public String getMethodName() {
		return SlackWebApiConstants.RTM_START;
	}

	@Override
	public void validate(List<ValidationError> errors) {
		// ignore
	}

	@Override
	protected void createParameters(Map<String, String> parameters) {
		if (simple_latest != null) {
			parameters.put("simple_latest", simple_latest);
		}
		if (no_unreads != null) {
			parameters.put("no_unreads", simple_latest);
		}
		if (mpim_aware != null) {
			parameters.put("mpim_aware", simple_latest);
		}
	}

}
