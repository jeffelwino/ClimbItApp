package com.techelevator.model;

public class State {
    private String stateAbbrev;
    private String stateName;
    private double latitude;
    private double longitude;

    public State() {
    }

    public State(String stateAbbrev, String stateName, double latitude, double longitude) {
        this.stateAbbrev = stateAbbrev;
        this.stateName = stateName;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getStateAbbrev() {
        return stateAbbrev;
    }

    public void setStateAbbrev(String stateAbbrev) {
        this.stateAbbrev = stateAbbrev;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
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
                ", stateName='" + stateName + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
