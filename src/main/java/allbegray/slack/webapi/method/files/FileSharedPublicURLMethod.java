package allbegray.slack.webapi.method.files;

import allbegray.slack.validation.Problem;
import allbegray.slack.validation.ValidationError;
import allbegray.slack.webapi.SlackWebApiConstants;
import allbegray.slack.webapi.method.AbstractMethod;

import java.util.List;
import java.util.Map;

/**
 * Created by allbegray on 2016-06-14.
 */
public class FileSharedPublicURLMethod extends AbstractMethod {

    public FileSharedPublicURLMethod(String file) {
        this.file = file;
    }

    protected String file;

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    @Override
    public String getMethodName() {
        return SlackWebApiConstants.FILES_SHARED_PUBLIC_URL;
    }

    @Override
    public void validate(List<ValidationError> errors) {
        if (file == null) {
            addError(errors, "file", Problem.REQUIRED);
        }
    }

    @Override
    protected void createParameters(Map<String, String> parameters) {
        parameters.put("file", file);
    }

}
