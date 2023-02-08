package com.techelevator.model;

public class Picture {

    public String photoId;
    private String url;
    private String publicId;

    public Picture(String photoId, String url, String publicId) {
        this.photoId = photoId;
        this.url = url;
        this.publicId = publicId;
    }

    public String getPhotoId() {
        return photoId;
    }

    public String getUrl() {
        return url;
    }

    public String getPublicId() {
        return publicId;
    }
}
