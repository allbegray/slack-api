package allbegray.slack.webapi.api;

import allbegray.slack.type.Team;
import allbegray.slack.type.TeamAccessLogList;
import allbegray.slack.type.TeamIntegrationLogList;

public interface TeamApi {

    TeamAccessLogList getTeamAccessLogList(int page);

    TeamAccessLogList getTeamAccessLogList(int page, int count);

    Team getTeamInfo();

    TeamIntegrationLogList getTeamIntegrationLogList(int page);

    TeamIntegrationLogList getTeamIntegrationLogList(int page, int count);

    TeamIntegrationLogList getTeamIntegrationLogList(String service_id, String app_id, String user, String change_type,
        int page, int count);
}
