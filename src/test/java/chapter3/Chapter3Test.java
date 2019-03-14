package chapter3;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@RunWith(DataProviderRunner.class)
public class Chapter3Test {

    private static final String BASE_URI = "http://api.zippopotam.us/";

    @Test
    @UseDataProvider("dataProviderWithPlaces")
    public void parametrizedTest(String country, String zipCode, String placeName) {
        given().pathParam("countryCode", country).pathParam("zipCode", zipCode)
                .get(BASE_URI+"{countryCode}/{zipCode}")
                .then().assertThat().body("places[0].'place name'", equalTo(placeName));

    }

    @DataProvider
    public static Object[][] dataProviderWithPlaces() {
        return new Object[][] {
                { "BR", "01000-000", "São Paulo" },
                { "GG", "GY1", "St Peter Port" },
        };
    }
}