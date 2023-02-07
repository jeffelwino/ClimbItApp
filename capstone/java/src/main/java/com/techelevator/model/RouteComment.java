package com.techelevator.model;

import java.time.LocalDate;

public class RouteComment extends Comment{
    private String routeId;

    public RouteComment() {
    }

    public RouteComment(int commentId, String body, int profileId, LocalDate postDate, String routeId) {
        super(commentId, body, profileId, postDate);
        this.routeId=routeId;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    @Override
    public String toString() {
        return "RouteComment{" +
                "routeId='" + routeId + '\'' +
                '}';
    }
}
