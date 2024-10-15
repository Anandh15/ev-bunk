package com.SpringBoot.form.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.SpringBoot.form.model.Station;

public interface StationRepo extends JpaRepository<Station, Integer> {
    
    Optional<Station> findByStationName(String stationName);

    List<Station> findByLatitudeAndLongitude(Double latitude, Double longitude);
    
    @Query("SELECT s FROM Station s WHERE s.latitude BETWEEN :lat1 AND :lat2 AND s.longitude BETWEEN :lon1 AND :lon2")
    List<Station> findStationsWithinRange(Double lat1, Double lat2, Double lon1, Double lon2);

}
