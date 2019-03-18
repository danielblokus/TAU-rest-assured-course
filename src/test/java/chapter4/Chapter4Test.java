package chapter4;

import helpers.HttpStatusCodes;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Chapter4Test {

    private static final String BASE_URI = "http://api.zippopotam.us/";
    private static final String PLACE_NAME = "São Paulo";

    private static RequestSpecification requestSpecification;
    private static ResponseSpecification responseSpecification;

    @BeforeClass
    public static void createRequestSpecification() {
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .build();

        responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(HttpStatusCodes.SUCCESS)
                .expectContentType(ContentType.JSON)
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

    @Test
    public void checkResponseHttpStatusCodeAndJsonContentTypeWithResponseSpecification() {
        given()
            .spec(requestSpecification)
        .when()
            .get("br/01000-000")
        .then()
            .spec(responseSpecification)
        .and()
            .assertThat()
                .body("places[0].'place name'", equalTo(PLACE_NAME));
    }

}