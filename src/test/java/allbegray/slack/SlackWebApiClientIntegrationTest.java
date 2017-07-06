package allbegray.slack;

import allbegray.slack.exception.SlackResponseErrorException;
import allbegray.slack.type.Authentication;
import allbegray.slack.webapi.SlackWebApiClient;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.*;

import java.io.IOException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class SlackWebApiClientIntegrationTest {

    @Rule
    public WireMockRule wireMockRule = new WireMockRule();
    private static final String TEST_TOKEN = "testtoken";
    private SlackWebApiClient slackWebApiClient;

    @Before
    public void setUp() {
        slackWebApiClient = SlackClientFactory.createWebApiClient(TEST_TOKEN);
    }

    @After
    public void tearDown() {
        slackWebApiClient.shutdown();
    }

    @Test
    public void testWireMock() throws IOException {

        stubFor(get(urlPathEqualTo("/auth.test")).willReturn(aResponse().withBody("hello world")));

        HttpGet get = new HttpGet("http://localhost:8080/auth.test");
        CloseableHttpClient httpclient = HttpClients.createDefault();
        CloseableHttpResponse response = httpclient.execute(get);
        try {
            System.out.println("***** " + response.getStatusLine().getStatusCode());
            System.out.println("***** " + EntityUtils.toString(response.getEntity()));
        } finally {
            response.close();
        }

    }

    @Test
    public void shouldAuthenticateWithATestTokenAgainstTheMockApi() {

        stubFor(post(urlPathEqualTo("/auth.test"))
                .withRequestBody(equalTo("token=" + TEST_TOKEN))
                .willReturn(aResponse().withStatus(200)
                        .withBody("{" +
                                "  \"ok\": true," +
                                "  \"url\": \"https:\\/\\/myteam.slack.com\\/\"," +
                                "  \"team\": \"My Team\"," +
                                "  \"user\": \"Me\"," +
                                "  \"team_id\": \"T12345\"," +
                                "  \"user_id\": \"U12345\"" +
                                "}")));

        slackWebApiClient.setWebApiUrl("http://localhost:8080");

        Authentication auth = slackWebApiClient.auth();

        Assert.assertEquals("T12345", auth.getTeam_id());
        Assert.assertEquals("U12345", auth.getUser_id());
        Assert.assertEquals("Me", auth.getUser());
        Assert.assertEquals("My Team", auth.getTeam());
        Assert.assertEquals("https://myteam.slack.com/", auth.getUrl());

    }

    @Test(expected = SlackResponseErrorException.class)
    public void shouldNotAuthenticateWithATestTokenAgainstTheDefaultApi() {

        try {
            slackWebApiClient.auth();
        }
        catch (SlackResponseErrorException e) {

            Assert.assertTrue(e.getMessage().contains("invalid_auth"));
            throw e;

        }

    }

}
