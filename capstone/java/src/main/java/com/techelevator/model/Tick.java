package com.techelevator.model;

import java.time.LocalDate;

public class Tick {
    private int id;
    private String routeId;
    private int profileId;
    private LocalDate date;
    private String note;
    private int rating;

    public Tick() {
    }

    public Tick(int id, String routeId, int profileId, LocalDate date, String note, int rating) {
        this.id = id;
        this.routeId = routeId;
        this.profileId = profileId;
        this.date = date;
        this.note = note;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Tick{" +
                "tickId=" + id +
                ", routeId='" + routeId + '\'' +
                ", profileId=" + profileId +
                ", date=" + date +
                ", note='" + note + '\'' +
                ", individualRating=" + rating +
                '}';
    }
}
