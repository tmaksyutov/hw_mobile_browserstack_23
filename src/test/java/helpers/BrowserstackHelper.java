package helpers;

import config.BrowserstackConfig;
import org.aeonbits.owner.ConfigFactory;

import static io.restassured.RestAssured.given;
import static java.lang.String.format;

public class BrowserstackHelper {
    //curl -u "username:password" -X GET "https://api.browserstack.com/app-automate/sessions/{sessionId}.json"

    static BrowserstackConfig config = ConfigFactory.create(BrowserstackConfig.class);
    public static String getBrowserstackVideoUrl(String sessionId){

        String url = format("https://api.browserstack.com/app-au" +
                "tomate/sessions/%s.json", sessionId);

        return given()
                .log().all()
                .auth().basic(config.user(), config.key())
                .when()
                .get(url)
                .then()
                .log().all()
                .statusCode(200)
                .extract().path("automation_session.video_url");

    }
}
