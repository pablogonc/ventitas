package Apis.LocationService.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class LocationResponse {
    @JsonProperty("items")
    public List <LocationDetails> detalles;
}
