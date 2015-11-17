package flowctrl.integration.slack;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;

public abstract class AbstractResponseHandler<T> implements ResponseHandler<T> {

	@Override
	public T handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
		final StatusLine statusLine = response.getStatusLine();
		int status = statusLine.getStatusCode();
		if (status >= 200 && status < 300) {
			HttpEntity entity = response.getEntity();
			return entity != null ? handle(entity) : null;
		} else {
			throw new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase());
		}
	}

	protected abstract T handle(HttpEntity entity) throws IllegalStateException, IOException;

}