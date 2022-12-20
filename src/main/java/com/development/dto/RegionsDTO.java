package com.development.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class RegionsDTO {
    @JsonProperty("region_id")
    private Long region_id;

    @JsonProperty("level1_name")
    private String level1_name;
    @JsonProperty("level1_code")
    private String level1_code;
    @JsonProperty("level2_name")
    private String level2_name;
    @JsonProperty("level2_code")
    private String level2_code;
    @JsonProperty("level3_name")
    private String level3_name;
    @JsonProperty("level3_code")
    private String level3_code;
    @JsonProperty("level4_name")
    private String level4_name;
    @JsonProperty("level4_code")
    private String level4_code;

    @JsonProperty("City")
    private List<CityDTO> citys;
    private boolean active=Boolean.FALSE;

}
