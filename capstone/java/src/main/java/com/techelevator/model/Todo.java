package com.techelevator.model;

public class Todo {
    private int profileId;
    private String routeId;

    public Todo(int profileId, String routeId) {
        this.profileId = profileId;
        this.routeId = routeId;
    }

    public Todo() {
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "profileId=" + profileId +
                ", routeId='" + routeId + '\'' +
                '}';
    }
}
