package com.techelevator.model.locations;

public class Route {
    private String id;
    private String wallId;
    private String name;
    private String grade;
    private String height;
    private String style;
    private String protection;

    public Route(String id, String wallId, String name, String grade, String height, String style, String protection) {
        this.id = id;
        this.wallId = wallId;
        this.name = name;
        this.grade = grade;
        this.height = height;
        this.style = style;
        this.protection = protection;
    }

    public Route() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWallId() {
        return wallId;
    }

    public void setWallId(String wallId) {
        this.wallId = wallId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                "routeId='" + id + '\'' +
                ", wallId='" + wallId + '\'' +
                ", routeName='" + name + '\'' +
                ", grade='" + grade + '\'' +
                ", height='" + height + '\'' +
                ", style='" + style + '\'' +
                ", protection='" + protection + '\'' +
                '}';
    }
}
