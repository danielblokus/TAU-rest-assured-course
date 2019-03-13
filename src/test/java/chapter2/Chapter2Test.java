package chapter2;

import helpers.HttpStatusCodes;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Chapter2Test {

    @Test
    public void checkResponseContentType() {
        given()
        .when()
            .get()
        .then()
            .assertThat()
                .contentType(ContentType.JSON);
    }

    @Test
    public void checkResponseHttpStatusCode() {
        given()
        .when()
            .get()
        .then()
            .assertThat()
                .statusCode(HttpStatusCodes.SUCCESS);
    }
}