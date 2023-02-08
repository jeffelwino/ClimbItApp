package com.techelevator.model;

public class Profile {
    private int id;
    private int userId;
    private String name;
    private String pictureId;
    private String location;
    private String bio;


    public Profile(){
    }

    public Profile(int id, int userId, String name, String pictureId, String location, String bio) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.pictureId = pictureId;
        this.location = location;
        this.bio = bio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPictureId() {
        return pictureId;
    }

    public void setPictureId(String pictureId) {
        this.pictureId = pictureId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "profileId=" + id +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                ", pictureId=" + pictureId +
                ", location='" + location + '\'' +
                ", bio='" + bio + '\'' +
                '}';
    }
}
