package com.techelevator.dao.locations;

import com.techelevator.model.locations.Crag;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcCragDao implements CragDao{
    private JdbcTemplate jdbcTemplate;

    public JdbcCragDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Crag addCrag(Crag crag) {
        String sql = "INSERT INTO crag (area_id, name, description, latitude, longitude)" +
                "VALUES (?,?,?,?,?) " +
                "RETURNING id ";
        String id = jdbcTemplate.queryForObject(sql, String.class, crag.getAreaId(),
                crag.getName(),crag.getDescription(),crag.getLatitude(),crag.getLongitude(),crag.getId());
        return getCragById(id);
    }

    @Override
    public List<Crag> getAllCrags() {
        List<Crag> crags= new ArrayList<>();
        String sql = "SELECT id, area_id, name, description, latitude, longitude " +
                "FROM crags ";
        SqlRowSet results= jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            crags.add(mapRowToCrag(results));
        }
        return crags;
    }

    @Override
    public Crag getCragById(String id) {
        Crag crag=null;
        String sql = "SELECT id, area_id, name, description, latitude, longitude " +
                "FROM crags " +
                "WHERE id=?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if(results.next()){
            crag=mapRowToCrag(results);
        }
        return crag;
    }

    @Override
    public boolean updateCrag(Crag crag) {
        String sql = "UPDATE crag" +
                "SET area_id=?, name=?, description=?, latitude=?, longitude=? " +
                "WHERE values=?";
        int updatedRows = jdbcTemplate.update(sql, crag.getAreaId(), crag.getName(),
                crag.getDescription(),crag.getLatitude(),crag.getLongitude(),crag.getId());
        return updatedRows==1;
    }

    @Override
    public boolean deleteCrag(String id) {
        String sql = "DELETE FROM crag " +
                "WHERE id = ?";
        int deletedRows = jdbcTemplate.update(sql, id);
        return deletedRows==1;
    }

    Crag mapRowToCrag(SqlRowSet results){
        String id = results.getString("id");
        String areaId=results.getString("area_id");
        String name=results.getString("name");
        String description = results.getString("description");
        double latitude=results.getDouble("latitude");
        double longitude=results.getDouble("longitude");
        return new Crag(id, areaId,name,description,latitude,longitude);
    }
}
