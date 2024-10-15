package com.SpringBoot.form.dto;


public class StationDto {
    private Integer id;
    private String stationName;
    private double latitude;
    private double longitude;
    private String address;
    private String mobile;
    private int capacity;
    private int usageValue;

    public StationDto() {
    }

    public StationDto(Integer id, String stationName, double latitude, double longitude, String address, String mobile, int capacity, int usageValue) {
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
