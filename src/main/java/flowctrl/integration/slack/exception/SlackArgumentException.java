package flowctrl.integration.slack.exception;

public class SlackArgumentException extends SlackException {

	private static final long serialVersionUID = 1L;

	public SlackArgumentException() {
		super();
	}

	public SlackArgumentException(String message, Throwable cause) {
		super(message, cause);
	}

	public SlackArgumentException(String message) {
		super(message);
	}

	public SlackArgumentException(Throwable cause) {
		super(cause);
	}

}
