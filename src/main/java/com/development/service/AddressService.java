package com.development.service;

import com.development.address.Address;
import com.development.repository.Address_repository;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class AddressService {
    @Autowired
    Address_repository addressRepository;
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
}
