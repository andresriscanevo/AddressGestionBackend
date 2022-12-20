package com.development.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Place_TypeDTO {
    @JsonProperty("place_type_id")
    private Long place_type_id;
    @JsonProperty("place_type_name")
    private String place_type_name;
    @JsonProperty("place_type_code")
    private String place_type_code;
    private boolean active=Boolean.FALSE;
}
