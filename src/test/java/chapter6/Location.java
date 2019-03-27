package chapter6;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.List;

@JsonPropertyOrder({"postCode", "country", "countryAbbreviation", "places"})
public class Location {

    private String postCode;
    private String country;
    private String countryAbbreviations;
    private List<Place> places;

    public Location() {
        this.postCode = "0200";
        this.country = "Australia";
        this.countryAbbreviations = "AU";

        Place place = new Place();
        ArrayList<Place> places = new ArrayList<>();
        places.add(place);

        this.places = places;
    }

    @JsonProperty("post code")
    public String getPostCode() {
        return postCode;
    }

    @JsonProperty("post code")
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("country abbreviation")
    public String getCountryAbbreviations() {
        return countryAbbreviations;
    }

    @JsonProperty("country abbreviation")
    public void setCountryAbbreviations(String countryAbbreviations) {
        this.countryAbbreviations = countryAbbreviations;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }
}