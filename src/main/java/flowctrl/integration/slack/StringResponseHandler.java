package flowctrl.integration.slack;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.util.EntityUtils;

public class StringResponseHandler extends AbstractResponseHandler<String> {

	@Override
	protected String handle(HttpEntity entity) throws ParseException, IOException {
		return EntityUtils.toString(entity);
	}

}