package com.techelevator.dao.locations;

import com.techelevator.model.locations.Route;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcRouteDao implements RouteDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcRouteDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Route addRoute(Route route) {
        String sql = "INSERT INTO routes (wall_id, name, grade, height, style, protection) " +
                "VALUES (?,?,?,?,?,?) " +
                "RETURNING id ";
        String routeId = jdbcTemplate.queryForObject(sql, String.class, route.getWallId(),
                route.getName(), route.getGrade(),route.getHeight(),route.getStyle(), route.getProtection());
        return getRouteById(routeId);
    }

    @Override
    public List<Route> getAllRoutes() {
        List<Route> routes = new ArrayList<>();
        String sql = "SELECT id, wall_id, name, grade, height, style, protection " +
                "FROM routes ";
        SqlRowSet results= jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            routes.add(mapRowToRoute(results));
        }
        return routes;
    }

    @Override
    public List<Route> getRouteByWallId(String id) {
        List<Route> routes = new ArrayList<>();
        String sql = "SELECT id, wall_id, name, grade, height, style, protection " +
                "FROM routes " +
                "WHERE wall_id=?";
        SqlRowSet results= jdbcTemplate.queryForRowSet(sql,id);
        while(results.next()){
            routes.add(mapRowToRoute(results));
        }
        return routes;
    }

    @Override
    public Route getRouteById(String routeId) {
        Route route=null;
        String sql = "SELECT id, wall_id, name, grade, height, style, protection " +
                "FROM routes " +
                "WHERE id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, routeId);
        if(results.next()){
            route = mapRowToRoute(results);
        }
        return route;
    }

    @Override
    public boolean updateRoute(Route route) {
        String sql = "UPDATE route " +
                "SET wall_id =?, name=?, grade=?, height=?, style=?, protection=? " +
                "WHERE id=?";
        int rowsUpdated = jdbcTemplate.update(sql, route.getWallId(), route.getName(),
                route.getGrade(),route.getHeight(),route.getStyle(), route.getProtection(), route.getId());
        return rowsUpdated==1;
    }

    @Override
    public boolean deleteRoute(String routeId) {
        String sql = "DELETE FROM account " +
                "WHERE id = ?";
        int rowsDeleted=jdbcTemplate.update(sql, routeId);
        return rowsDeleted==1;
    }

    private Route mapRowToRoute(SqlRowSet results){
        String routeId = results.getString("id");
        String wallId = results.getString("wall_id");
        String routeName = results.getString("name");
        String grade = results.getString("grade");
        String height=results.getString("height");
        String style=results.getString("style");
        String protection=results.getString("protection");
        return new Route(routeId,wallId,routeName,grade,height,style,protection);
    }
}
