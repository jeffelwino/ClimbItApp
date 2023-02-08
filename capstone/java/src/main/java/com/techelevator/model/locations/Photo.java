package com.techelevator.model.locations;

public class Photo {
    private String imageId;
    private String routeId;

    public Photo(String imageId, String routeId) {
        this.imageId = imageId;
        this.routeId = routeId;
    }

    public Photo() {

    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
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
                "imageId=" + imageId + '\'' +
                "routeId=" + routeId + '\'' +
                '}';
    }

}
