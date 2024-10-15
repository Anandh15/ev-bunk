package com.SpringBoot.form.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.SpringBoot.form.dto.StationDto;
import com.SpringBoot.form.model.Station;
import com.SpringBoot.form.repository.StationRepo;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StationService {

    @Autowired
    private StationRepo stationRepository;

    public List<Station> getAllStations() {
        return stationRepository.findAll();
    }

    public Optional<Station> getStationById(Integer id) {
        return stationRepository.findById(id);
    }

    public Optional<Station> findByStationName(String stationName) {
        return stationRepository.findByStationName(stationName);
    }
    
    


    @Transactional
    public Station saveStation(StationDto stationDto) {
        Station station = new Station();
        station.setStationName(stationDto.getStationName());
        station.setLatitude(stationDto.getLatitude());
        station.setLongitude(stationDto.getLongitude());
        station.setAddress(stationDto.getAddress());
        station.setMobile(stationDto.getMobile());
        station.setCapacity(stationDto.getCapacity());
        station.setUsageValue(stationDto.getUsageValue());

        return stationRepository.save(station);
    }

    @Transactional
    public Station updateStation(Integer id, StationDto stationDto) {
        Optional<Station> stationOpt = stationRepository.findById(id);

        if (stationOpt.isPresent()) {
            Station station = stationOpt.get();
            station.setStationName(stationDto.getStationName());
            station.setLatitude(stationDto.getLatitude());
            station.setLongitude(stationDto.getLongitude());
            station.setAddress(stationDto.getAddress());
            station.setMobile(stationDto.getMobile());
            station.setCapacity(stationDto.getCapacity());
            station.setUsageValue(stationDto.getUsageValue());

            return stationRepository.save(station);
        } else {
            throw new RuntimeException("Station with ID " + id + " not found");
        }
    }
    
    @Transactional
    public void deleteStation(Integer id) {
        Optional<Station> stationOpt = stationRepository.findById(id);

        if (stationOpt.isPresent()) {
            stationRepository.deleteById(id);
        } else {
            throw new RuntimeException("Station with ID " + id + " not found");
        }
    }

    public List<Station> findByLatitudeAndLongitude(Double latitude, Double longitude) {
        Double radius = 0.1; 
        return stationRepository.findStationsWithinRange(latitude - radius, latitude + radius, 
                                                         longitude - radius, longitude + radius);
    }

}
