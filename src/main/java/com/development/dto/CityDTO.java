package com.development.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CityDTO {
    @JsonProperty("city_id")
    private Long city_id;
    @JsonProperty("city_name")
    private String city_name;
    @JsonProperty("timezone")
    private String timezone;
    private boolean active=Boolean.FALSE;
}
