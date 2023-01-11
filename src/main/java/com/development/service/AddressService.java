package com.development.service;

import com.development.address.Address;
import com.development.address.City;
import com.development.address.Regions;
import com.development.mapstruct.MapStructMapper;
import com.development.repository.Address_repository;
import com.development.repository.City_repository;
import com.development.repository.Regions_repository;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class AddressService {
    @Autowired
    Address_repository addressRepository;
    Regions_repository regionsRepository;
    City_repository cityRepository;
    MapStructMapper mapStructMapper;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public AddressService(Address_repository addressRepository ,Regions_repository regionsRepository ,City_repository cityRepository){
        this.addressRepository =addressRepository;
        this.regionsRepository= regionsRepository;
        this.cityRepository=cityRepository;
    }
    @Autowired
    EntityManager entityManager;
    public List<Address> findAddressFilter(boolean isDeleted){
        Session session =entityManager.unwrap(Session.class);
        Filter filter=session.enableFilter("deletedAddressFilter");
        filter.setParameter("isDeleted",isDeleted);
        List<Address> addresses = addressRepository.findAddressByActiveFalse();
        session.disableFilter("deleteAddressFilter");
        return addresses;
    }
    public List<Regions> getRegionsByCountry(String country){
        return regionsRepository.findByCountry(country);
    }
    public List<City> getCityByRegion(String city){
        return cityRepository.findByCity(city);
    }
    public void exportdata(String tableaddress,String fileName) throws Exception{
        jdbcTemplate.update("CALL EXPORT_FILE.EXPORT_FILE(?,?)",tableaddress,fileName);
    }
}
