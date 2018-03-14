package allbegray.slack.webapi.method.groups;

import allbegray.slack.SlackClientFactory;
import allbegray.slack.type.Group;
import allbegray.slack.webapi.SlackWebApiClient;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import wiremock.org.apache.commons.lang3.RandomStringUtils;

public class GroupsTest {
    private static final int NAME_RANDOM_PART_SIZE = 9;

    private String token = "your slack web api token";
    private SlackWebApiClient webApiClient;

    @Before
    public void setup() {
        webApiClient = SlackClientFactory.createWebApiClient(token);
    }

    @Test
    public void createAndCloseTest() throws Exception {
        Group group = webApiClient.createGroup("ch" + RandomStringUtils.randomAlphanumeric(NAME_RANDOM_PART_SIZE).toLowerCase());
        Assert.assertNotNull(group.getId());

        webApiClient.closeGroup(group.getId());
    }
}
