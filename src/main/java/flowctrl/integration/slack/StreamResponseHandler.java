package flowctrl.integration.slack;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;

public class StreamResponseHandler extends AbstractResponseHandler<InputStream> {

	@Override
	protected InputStream handle(HttpEntity entity) throws IllegalStateException, IOException {
		return entity.getContent();
	}

}