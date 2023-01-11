package com.development.repository;

import com.development.address.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface City_repository extends JpaRepository<City,Long> {
    @Query("SELECT c FROM City c WHERE c.regions.level1_name = :city_name")
    List<City> findByCity(@Param("city_name") String city_name);
}
