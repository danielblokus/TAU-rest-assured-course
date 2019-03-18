package chapter4;

import helpers.HttpStatusCodes;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Chapter4Test {

    private static final String BASE_URI = "http://api.zippopotam.us/";

    private static RequestSpecification requestSpecification;

    @BeforeClass
    public static void createRequestSpecification() {
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .build();
    }

    @Test
    public void checkResponseHttpStatusCodeAndJsonContentType() {
        given()
            .spec(requestSpecification)
        .when()
            .get("br/01000-000")
        .then()
            .assertThat()
                .statusCode(HttpStatusCodes.SUCCESS)
                .and()
                .contentType(ContentType.JSON);
    }
}