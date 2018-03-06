package allbegray.slack.exception;

public class SlackResponseRateLimitException extends SlackResponseErrorException {
    private static final Long DEFAULT_RETRY_AFTER = 60L;

    private Long retryAfter = DEFAULT_RETRY_AFTER;

    public SlackResponseRateLimitException(Long retryAfter) {
        this.retryAfter = retryAfter;
    }

    public Long getRetryAfter() {
        return this.retryAfter;
    }
}
