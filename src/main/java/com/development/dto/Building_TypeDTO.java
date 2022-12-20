package com.development.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Building_TypeDTO {
    @JsonProperty("building_type_id")
    private Long building_type_id;
    @JsonProperty("building_type_name")
    private String building_type_name;
    @JsonProperty("building_type_code")
    private String building_type_code;
    @JsonProperty("building_type_use")
    private String building_type_use;
    private boolean active=Boolean.FALSE;
}
