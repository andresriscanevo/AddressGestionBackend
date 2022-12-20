package com.development.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CountryDTO {
    @JsonProperty("country_id")
    private Long country_id;
    @JsonProperty("country_name")
    private String country_name;
    @JsonProperty("country_code")
    private String country_code;
    @JsonProperty("regions")
    private List<RegionsDTO> regions;
    private boolean active=Boolean.FALSE;
}

