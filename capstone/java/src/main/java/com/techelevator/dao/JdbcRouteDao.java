package com.techelevator.dao;

import com.techelevator.model.Route;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcRouteDao implements RouteDao{
    private JdbcTemplate jdbcTemplate;

    public JdbcRouteDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Route addRoute(Route route) {
        String sql = "INSERT INTO routes (wall_id, route_name, grade, height, style, protection) " +
                "VALLLUES (?,?,?,?,?,?) " +
                "RETURNING route_id ";
        String routeId = jdbcTemplate.queryForObject(sql, String.class, route.getWallId(),
                route.getRouteName(), route.getGrade(),route.getHeight(),route.getStyle(), route.getProtection());
        return getRouteById(routeId);
    }

    @Override
    public List<Route> getAllRoutes() {
        List<Route> routes = new ArrayList<>();
        String sql = "SELECT route_id, wall_id, route_name, grade, height, style, protection " +
                "FROM routes ";
        SqlRowSet results= jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            routes.add(mapRowToRoute(results));
        }
        return routes;
    }

    @Override
    public Route getRouteById(String routeId) {
        Route route=null;
        String sql = "SELECT route_id, wall_id, route_name, grade, height, style, protection " +
                "FROM routes " +
                "WHERE route_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, routeId);
        if(results.next()){
            route = mapRowToRoute(results);
        }
        return route;
    }

    @Override
    public boolean updateRoute(Route route) {
        String sql = "UPDATE route " +
                "SET wall_id =?, route_name=?, grade=?, height=?, style=?, protection=? " +
                "WHERE route_id=?";
        int rowsUpdated = jdbcTemplate.update(sql, route.getWallId(), route.getRouteName(),
                route.getGrade(),route.getHeight(),route.getStyle(), route.getProtection(), route.getRouteId());
        return rowsUpdated==1;
    }

    @Override
    public boolean deleteRoute(String routeId) {
        String sql = "DELETE FROM account " +
                "WHERE route_id = ?";
        int rowsDeleted=jdbcTemplate.update(sql, routeId);
        return rowsDeleted==1;
    }

    private Route mapRowToRoute(SqlRowSet results){
        String routeId = results.getString("route_id");
        String wallId = results.getString("wall_id");
        String routeName = results.getString("route_name");
        String grade = results.getString("grade");
        String height=results.getString("height");
        String style=results.getString("style");
        String protection=results.getString("protection");
        return new Route(routeId,wallId,routeName,grade,height,style,protection);
    }
}
