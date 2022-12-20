package com.development.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ZonesDTO {
    @JsonProperty("zone_id")
    private Long zone_id;
    // concatenacion con city

    //fin concatenacion
    @JsonProperty("zone_name")
    private String zone_name;
    private boolean active;
}
