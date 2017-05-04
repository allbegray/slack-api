package allbegray.slack.webapi.api;

import java.io.InputStream;

import allbegray.slack.type.Comment;
import allbegray.slack.type.File;
import allbegray.slack.type.FileInfo;
import allbegray.slack.type.FileList;
import allbegray.slack.webapi.SlackWebApiConstants;

public interface FilesApi {

    boolean deleteFile(String file);

    FileInfo getFileInfo(String file);

    FileInfo getFileInfo(String file, int page);

    FileInfo getFileInfo(String file, int page, int count);

    default FileList getFileList() {
        return getFileList(null, null, null, null, SlackWebApiConstants.DEFAULT_PAGE, SlackWebApiConstants.DEFAULT_COUNT);
    }

    default FileList getFileList(int page) {
        return getFileList(null, null, null, null, page, SlackWebApiConstants.DEFAULT_COUNT);
    }

    default FileList getFileList(int page, int count) {
        return getFileList(null, null, null, null, page, count);
    }

    default FileList getFileList(String user) {
        return getFileList(user, null, null, null, SlackWebApiConstants.DEFAULT_PAGE, SlackWebApiConstants.DEFAULT_COUNT);
    }

    default FileList getFileList(String user, int page) {
        return getFileList(user, null, null, null, page, SlackWebApiConstants.DEFAULT_COUNT);
    }

    default FileList getFileList(String user, int page, int count) {
        return getFileList(user, null, null, null, page, count);
    }

    FileList getFileList(String user, String ts_from, String ts_to, String types, int page, int count);

    File revokeFilePublicURL(String file);

    File sharedFilePublicURL(String file);

    File uploadFile(java.io.File file, String title, String initial_comment, String channels);

    File uploadFile(java.io.File file, String filetype, String filename, String title, String initial_comment, String channels);

    File uploadFile(InputStream is, String filetype, String filename, String title, String initial_comment, String channels);

    Comment addFileComment(String file, String comment);

    Comment editFileComment(String file, String id, String comment);

    boolean deleteFileComment(String file, String id);
}
