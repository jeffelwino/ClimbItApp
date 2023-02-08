package com.techelevator.model.locations;

public class State {
    private String abbrev;
    private String name;
    private double latitude;
    private double longitude;

    public State() {
    }

    public State(String abbrev, String name, double latitude, double longitude) {
        this.abbrev = abbrev;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getAbbrev() {
        return abbrev;
    }

    public void setAbbrev(String abbrev) {
        this.abbrev = abbrev;
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
                "stateAbbrev='" + abbrev + '\'' +
                ", stateName='" + name + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
