package com.development.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class AddressDTO {
    @JsonProperty("address_id")
    private Long address_id;
    //asociacion del dto externo building
    private Way_TypeDTO way_type;
    @JsonProperty("way_main")
    private String way_main;
    @JsonProperty("way_secondary")
    private String way_secondary;
    private Building_TypeDTO building_type;

    private Place_TypeDTO place_type;
    @JsonProperty("place_name")
    private String place;
    @JsonProperty("addr_txt")
    private String addr_txt;
    @JsonProperty("latitude")
    private float latitude;
    @JsonProperty("longitude")
    private float longitude;
    private CountryDTO country;


    private boolean active=Boolean.FALSE;


    //constructor




    //getters y setters



}
