package com.development.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Way_TypeDTO {
    @JsonProperty("way_type_id")
    private Long way_type_id;
    @JsonProperty("way_type_name")
    private String way_type_name;
    @JsonProperty("way_type_code")
    private String way_type_code;

    private boolean active=Boolean.FALSE;


}
