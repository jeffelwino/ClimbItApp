package com.techelevator.model.locations;

public class Wall {
    private String id;
    private String cragId;
    private String name;
    private String description;

    public Wall(String id, String cragId, String name, String description) {
        this.id = id;
        this.cragId = cragId;
        this.name = name;
        this.description = description;
    }

    public Wall() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCragId() {
        return cragId;
    }

    public void setCragId(String cragId) {
        this.cragId = cragId;
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

    @Override
    public String toString() {
        return "Wall{" +
                "wallId='" + id + '\'' +
                ", cragId='" + cragId + '\'' +
                ", wallName='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
