package com.techelevator.model;

public class Todo {
    private int todoId;
    private int profileId;
    private String routeId;

    public Todo(int todoId, int profileId, String routeId) {
        this.todoId = todoId;
        this.profileId = profileId;
        this.routeId = routeId;
    }

    public Todo() {
    }

    public int getTodoId() {
        return todoId;
    }

    public void setTodoId(int todoId) {
        this.todoId = todoId;
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "todoId=" + todoId +
                ", profileId=" + profileId +
                ", routeId='" + routeId + '\'' +
                '}';
    }
}
