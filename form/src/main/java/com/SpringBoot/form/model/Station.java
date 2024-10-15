package com.SpringBoot.form.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="stations_list")
public class Station {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name="StationName", nullable = false, unique = true, length = 255)
    private String stationName;
    
    @Column(name="Latitude", nullable = false, length = 255)
    private double latitude;
    
    @Column(name="Longitude", nullable = false, length = 255)
    private double longitude;
    
    @Column(name="Address", nullable = false, length = 255)
    private String address;
    
    @Column(name="Mobile", nullable = false, length = 15)
    private String mobile;
    
    @Column(name="Capacity", nullable = false)
    private int capacity;
    
    @Column(name="UsageValue", nullable = false)
    private int usageValue;

    // Default constructor
    public Station() {
    }

    public Station(Integer id, String stationName, double latitude, double longitude, String address, String mobile, int capacity, int usageValue) {
        this.id = id;
        this.stationName = stationName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
        this.mobile = mobile;
        this.capacity = capacity;
        this.usageValue = usageValue;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getUsageValue() {
        return usageValue;
    }

    public void setUsageValue(int usageValue) {
        this.usageValue = usageValue;
    }
}
