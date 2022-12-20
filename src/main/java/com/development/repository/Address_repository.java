package com.development.repository;

import com.development.address.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Address_repository extends JpaRepository<Address,Long> {
    List<Address> findAddressByActiveFalse();
    //List<Address> findByActiveFalse();

}

