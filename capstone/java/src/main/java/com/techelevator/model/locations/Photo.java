package com.techelevator.model.locations;

public class Photo {
    private String photoId;
    private String routeId;

    public Photo(String photoId, String routeId) {
        this.photoId = photoId;
        this.routeId = routeId;
    }


    public Photo() {

    }

    public String getPhotoId() {
        return photoId;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "imageId=" + photoId + '\'' +
                "routeId=" + routeId + '\'' +
                '}';
    }

}
