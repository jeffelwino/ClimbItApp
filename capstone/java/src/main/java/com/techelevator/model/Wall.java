package com.techelevator.model;

public class Wall {
    private String wallId;
    private String cragId;
    private String wallName;
    private String description;

    public Wall(String wallId, String cragId, String wallName, String description) {
        this.wallId = wallId;
        this.cragId = cragId;
        this.wallName = wallName;
        this.description = description;
    }

    public Wall() {
    }

    public String getWallId() {
        return wallId;
    }

    public void setWallId(String wallId) {
        this.wallId = wallId;
    }

    public String getCragId() {
        return cragId;
    }

    public void setCragId(String cragId) {
        this.cragId = cragId;
    }

    public String getWallName() {
        return wallName;
    }

    public void setWallName(String wallName) {
        this.wallName = wallName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Wall{" +
                "wallId='" + wallId + '\'' +
                ", cragId='" + cragId + '\'' +
                ", wallName='" + wallName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
