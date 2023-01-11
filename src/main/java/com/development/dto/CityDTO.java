package com.development.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CityDTO {
    @JsonProperty("city_id")
    private Long city_id;
    @JsonProperty("city_name")
    private String city_name;
    @JsonProperty("timezone")
    private String timezone;
    @JsonProperty("active")
    private boolean active=Boolean.FALSE;
    private List<ZonesDTO> zones;
}
