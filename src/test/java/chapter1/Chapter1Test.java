package chapter1;

import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Chapter1Test {

    private static final String URL = "http://api.zippopotam.us/PL/76-200";
    private static final String PLACE_NAME = "Słupsk";

    @BeforeClass
    public static void setUp() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails(LogDetail.ALL);
    }

    @Test
    public void checkResponseBodyHaveExpectedPlaceName() {
        given()
        .when()
            .get(URL)
        .then()
            .assertThat()
                .body("places[0].'place name'", equalTo(PLACE_NAME));
    }
}