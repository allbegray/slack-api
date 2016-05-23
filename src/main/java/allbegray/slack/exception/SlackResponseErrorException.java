package allbegray.slack.exception;

public class SlackResponseErrorException extends SlackException {

	private static final long serialVersionUID = 1L;

	public SlackResponseErrorException() {
		super();
	}

	public SlackResponseErrorException(String message, Throwable cause) {
		super(message, cause);
	}

	public SlackResponseErrorException(String message) {
		super(message);
	}

	public SlackResponseErrorException(Throwable cause) {
		super(cause);
	}

}
