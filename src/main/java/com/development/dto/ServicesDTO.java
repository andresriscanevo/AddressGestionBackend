package com.development.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServicesDTO {
    @JsonProperty("service_id")
    private Long service_id;
    @JsonProperty("service_name")
    private String service_name;
    @JsonProperty("type_service")
    private String type_service;
    @JsonProperty("status_service")
    private String status_service;
    private boolean active;
}
