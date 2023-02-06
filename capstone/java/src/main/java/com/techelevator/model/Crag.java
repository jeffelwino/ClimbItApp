package com.techelevator.model;

public class Crag {
    private String id;
    private String areaId;
    private String name;
    private String description;
    private double latitude;
    private double longitude;

    public Crag(String id, String areaId, String cragName, String description, double latitude, double longitude) {
        this.id = id;
        this.areaId = areaId;
        this.name = cragName;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Crag() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    @Override
    public String toString() {
        return "Crag{" +
                "cragId='" + id + '\'' +
                ", areaId='" + areaId + '\'' +
                ", cragName='" + name + '\'' +
                ", description='" + description + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
