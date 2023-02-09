package com.techelevator.model;

public class ProfilePhotoDto {

    private int profileId;
    private String photoId;

    public ProfilePhotoDto(int profileId, String photoId) {
        this.profileId = profileId;
        this.photoId = photoId;
    }

    public ProfilePhotoDto() {
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public String getPhotoId() {
        return photoId;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId;
    }
}
