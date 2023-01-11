package com.development.repository;

import com.development.address.City;
import com.development.address.Zones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Zones_repository extends JpaRepository<Zones,Long> {
    @Query("SELECT z FROM City z WHERE z.zoness = :city_name")
    List<City> findByCity(@Param("city_name") String city_name);
}
