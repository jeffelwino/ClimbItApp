package com.techelevator.model;

public class Route {
    private String routeId;
    private String wallId;
    private String routeName;
    private String grade;
    private String height;
    private String style;
    private String protection;

    public Route(String routeId, String wallId, String routeName, String grade, String height, String style, String protection) {
        this.routeId = routeId;
        this.wallId = wallId;
        this.routeName = routeName;
        this.grade = grade;
        this.height = height;
        this.style = style;
        this.protection = protection;
    }

    public Route() {
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public String getWallId() {
        return wallId;
    }

    public void setWallId(String wallId) {
        this.wallId = wallId;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getProtection() {
        return protection;
    }

    public void setProtection(String protection) {
        this.protection = protection;
    }


    @Override
    public String toString() {
        return "Route{" +
                "routeId='" + routeId + '\'' +
                ", wallId='" + wallId + '\'' +
                ", routeName='" + routeName + '\'' +
                ", grade='" + grade + '\'' +
                ", height='" + height + '\'' +
                ", style='" + style + '\'' +
                ", protection='" + protection + '\'' +
                '}';
    }
}
