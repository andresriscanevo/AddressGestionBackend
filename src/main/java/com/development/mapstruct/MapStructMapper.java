package com.development.mapstruct;


import com.development.address.*;
import com.development.dto.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(
        componentModel="spring"
)
public interface MapStructMapper {
    //mapeador de los dto a entidades
    MapStructMapper INSTANCE = Mappers.getMapper(MapStructMapper.class);
    @Mapping(source = "active", target = "active")
    AddressDTO addressToAddressDTO(Address address);
    @Mapping(source = "active", target = "active")
    List<AddressDTO> addressToAddressAllDTO(
            List<Address>addresses);
    @Mapping(source="active",target="active")
    Address addressDTOToAddress(AddressDTO addressDTO);
    Building_TypeDTO building_typeToBuilding_typeDTO(Building_type building_type);
    Building_type building_typeDTOToBuilding_Type(Building_TypeDTO building_typeDTO);

    City cityDTOToCity(CityDTO cityDTO);
    List<CityDTO> CityToCityAllDTO(List<City> cityList);
    Country countryDTOToCountry(CountryDTO countryDTO);
    CountryDTO CountryTocountryDTO(Country country);
    Place_type place_typeDTOToPlace_Type(Place_TypeDTO place_typeDTO);
    Way_type way_typeDTOToWay_Type(Way_TypeDTO way_typeDTO);
    RegionsDTO RegionsToregionsDTO(Regions regions);
    List<RegionsDTO> RegionsToRegionsAllDTO(List<Regions> regionsList);
    Regions regionsDTOToRegions(RegionsDTO regionsDTO);
    Services servicesDTOToServices(ServicesDTO servicesDTO);
    Zones zonesDTOToZones(ZonesDTO zonesDTO);
}
