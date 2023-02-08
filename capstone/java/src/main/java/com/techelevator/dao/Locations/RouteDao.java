package com.techelevator.dao.locations;

import com.techelevator.model.locations.Route;

import java.util.List;

public interface RouteDao {
//    CRUD
//    Create
    Route addRoute(Route route);
//    Read
    List<Route> getAllRoutes();
    List<Route> getRouteByWallId(String id);
    Route getRouteById(String routeId);
//    Update
    boolean updateRoute(Route route);
//    Delete
    boolean deleteRoute(String routeId);
}
