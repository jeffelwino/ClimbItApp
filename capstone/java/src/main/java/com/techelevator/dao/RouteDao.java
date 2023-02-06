package com.techelevator.dao;

import com.techelevator.model.Route;

import java.util.List;

public interface RouteDao {
//    CRUD
//    Create
    Route addRoute(Route route);
//    Read
    List<Route> getAllRoutes();
    Route getRouteById(String routeId);
//    Update
    boolean updateRoute(Route route);
//    Delete
    boolean deleteRoute(String routeId);
}
