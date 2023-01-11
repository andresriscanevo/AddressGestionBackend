package com.development.repository;

import com.development.address.Regions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Regions_repository extends JpaRepository<Regions,Long> {
    @Query("SELECT r FROM Regions r WHERE r.country.country_name= :country_name")
    List<Regions> findByCountry(@Param("country_name") String country_name);
}
