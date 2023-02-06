package com.techelevator.model;

public class Area {
    private String areaId;
    private String stateAbbrev;
    private String areaName;
    private String description;
    private double latitude;
    private double longitude;

    public Area() {
    }

    public Area(String areaId, String stateAbbrev, String areaName, String description, double latitude, double longitude) {
        this.areaId = areaId;
        this.stateAbbrev = stateAbbrev;
        this.areaName = areaName;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getStateAbbrev() {
        return stateAbbrev;
    }

    public void setStateAbbrev(String stateAbbrev) {
        this.stateAbbrev = stateAbbrev;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
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
                "areaId='" + areaId + '\'' +
                ", stateAbbrev='" + stateAbbrev + '\'' +
                ", areaName='" + areaName + '\'' +
                ", description='" + description + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
