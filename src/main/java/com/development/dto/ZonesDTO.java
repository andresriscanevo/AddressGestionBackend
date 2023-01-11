package com.development.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ZonesDTO {
    @JsonProperty("zone_id")
    private Long zone_id;
    // concatenacion con city

    //fin concatenacion
    @JsonProperty("zone_name")
    private String zone_name;
    @JsonProperty("active")
    private boolean active=Boolean.FALSE;
    //asociaciones de los dto de productos y servicios

    private List<ProductsDTO> productsDTOList;
    private List<ServicesDTO> servicesDTOList;
}
