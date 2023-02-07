package com.techelevator.dao.locations;

import com.techelevator.model.locations.Area;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcAreaDao implements AreaDao{
    private JdbcTemplate jdbcTemplate;

    public JdbcAreaDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Area addArea(Area area) {
        String sql = "INSERT INTO areas (state_abbrev, name, description, latitude, longitude) " +
                "VALUES (?,?,?,?,?) " +
                "RETURNING id ";
        String id = jdbcTemplate.queryForObject(sql, String.class, area.getStateAbbrev(),
                area.getName(), area.getDescription(),area.getLatitude(),area.getLongitude());
        return getAreaById(id);
    }

    @Override
    public List<Area> getAllAreas() {
        List<Area> areas = new ArrayList<>();
        String sql = "SELECT id, state_abbrev, name, description, latitude, longitude " +
                "FROM areas ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            areas.add(mapRowToArea(results));
        }
        return areas;
    }

    @Override
    public Area getAreaById(String id) {
        Area area = null;
        String sql = "SELECT id, state_abbrev, name, description, latitude, longitude " +
                "FROM areas " +
                "WHERE id=?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql,id);
        if(results.next()){
            area=mapRowToArea(results);
        }
        return area;
    }

    @Override
    public boolean updateArea(Area area) {
        String sql = "UPDATE areas " +
                "SET state_abbrev=?, name=?, description=?, latitude=?, longitude=? " +
                "WHERE id=?";
        int rowsUpdated = jdbcTemplate.update(sql, area.getStateAbbrev(),
                area.getName(), area.getDescription(),area.getLatitude(),area.getLongitude(), area.getId());
        return rowsUpdated==1;
    }

    @Override
    public boolean deleteArea(String id) {
        String sql = "DELETE FROM area " +
                "WHERE id=?";
        int rowsDeleted = jdbcTemplate.update(sql, id);
        return rowsDeleted==1;
    }

    private Area mapRowToArea(SqlRowSet results){
        String id = results.getString("id");
        String stateAbbrev = results.getString("state_abbrev");
        String name = results.getString("name");
        String description = results.getString("description");
        double latitude = results.getDouble("latitude");
        double longitude = results.getDouble("longitude");
        return new Area(id,stateAbbrev,name,description,latitude,longitude);
    }
}
