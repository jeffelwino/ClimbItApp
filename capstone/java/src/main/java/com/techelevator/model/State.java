package com.techelevator.model;

public class State {
    private String stateAbbrev;
    private String name;
    private double latitude;
    private double longitude;

    public State() {
    }

    public State(String stateAbbrev, String name, double latitude, double longitude) {
        this.stateAbbrev = stateAbbrev;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
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
        return "State{" +
                "stateAbbrev='" + stateAbbrev + '\'' +
                ", stateName='" + name + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
