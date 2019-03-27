package chapter6;

import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Chapter6Test {

    private static final String URL = "http://api.zippopotam.us/AU/0200";
    private static final String PLACE_STATE = "Australian Capital Territory";

    @Test
    public void checkPlaceStateFromDeserializedObject() {
        Location location =
        given()
        .when()
            .get(URL)
        .as(Location.class);

        Assert.assertEquals(PLACE_STATE, location.getPlaces().get(0).getState());
    }
}