package chapter2;

import helpers.HttpStatusCodes;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Chapter2Test {

    private static final String URL = "http://api.zippopotam.us/PL/76-200";

    @Test
    public void checkResponseContentType() {
        given()
        .when()
            .get(URL)
        .then()
            .assertThat()
                .contentType(ContentType.JSON);
    }

    @Test
    public void checkResponseHttpStatusCode() {
        given()
        .when()
            .get(URL)
        .then()
            .assertThat()
                .statusCode(HttpStatusCodes.SUCCESS);
    }
}