package com.development.repository;

import com.development.address.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Country_repository extends JpaRepository<Country,Long> {

}
