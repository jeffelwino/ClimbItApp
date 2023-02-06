package com.techelevator.model;

public class Area {
    private String id;
    private String stateAbbrev;
    private String name;
    private String description;
    private double latitude;
    private double longitude;

    public Area() {
    }

    public Area(String areaId, String stateAbbrev, String areaName, String description, double latitude, double longitude) {
        this.id = areaId;
        this.stateAbbrev = stateAbbrev;
        this.name = areaName;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStateAbbrev() {
        return stateAbbrev;
    }

    public void setStateAbbrev(String stateAbbrev) {
        this.stateAbbrev = stateAbbrev;
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
        return "Area{" +
                "areaId='" + id + '\'' +
                ", stateAbbrev='" + stateAbbrev + '\'' +
                ", areaName='" + name + '\'' +
                ", description='" + description + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
