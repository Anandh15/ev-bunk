package com.SpringBoot.form.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.SpringBoot.form.dto.StationDto;
import com.SpringBoot.form.model.Station;
import com.SpringBoot.form.service.StationService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/stations")
public class StationController {

    @Autowired
    private StationService stationService;
    
    @GetMapping("/search")
    public ResponseEntity<List<Station>> searchStations(
        @RequestParam Double latitude, 
        @RequestParam Double longitude) {
        List<Station> stations = stationService.findByLatitudeAndLongitude(latitude, longitude);
        return new ResponseEntity<>(stations, HttpStatus.OK);
    }




    @GetMapping
    public ResponseEntity<List<Station>> getAllStations() {
        List<Station> stations = stationService.getAllStations();
        return new ResponseEntity<>(stations, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStationById(@PathVariable Integer id) {
        Optional<Station> stationOpt = stationService.getStationById(id);
        if (stationOpt.isPresent()) {
            return new ResponseEntity<>(stationOpt.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Station not found", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Station> createStation(@RequestBody StationDto stationDto) {
        Station savedStation = stationService.saveStation(stationDto);
        return new ResponseEntity<>(savedStation, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStation(@PathVariable Integer id, @RequestBody StationDto stationDto) {
        try {
            Station updatedStation = stationService.updateStation(id, stationDto);
            return new ResponseEntity<>(updatedStation, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStation(@PathVariable Integer id) {
        try {
            stationService.deleteStation(id);
            return new ResponseEntity<>("Station deleted successfully", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
