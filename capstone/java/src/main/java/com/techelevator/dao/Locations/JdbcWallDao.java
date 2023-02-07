package com.techelevator.dao.locations;

import com.techelevator.model.locations.Wall;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcWallDao implements WallDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcWallDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Wall addWall(Wall wall) {
        String sql = "INSERT INTO walls (crag_id, name, description) " +
                "VALUES (?,?,?) " +
                "RETURNING id ";
        String id = jdbcTemplate.queryForObject(sql, String.class, wall.getCragId(), wall.getName(), wall.getDescription());
        return getWallById(id);
    }

    @Override
    public List<Wall> getAllWalls() {
        List<Wall> walls = new ArrayList<>();
        String sql = "SELECT id, crag_id, name, description " +
                "FROM walls ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            walls.add(mapRowToWall(results));
        }
        return walls;
    }

    @Override
    public Wall getWallById(String id) {
        Wall wall = null;
        String sql = "SELECT id, crag_id, name, description " +
                "FROM walls " +
                "WHERE id=?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if(results.next()){
            wall=mapRowToWall(results);
        }
        return wall;
    }

    @Override
    public boolean updateWall(Wall wall) {
        String sql = "UPDATE walls " +
                "SET crag_id=?, name=?, description=? " +
                "WHERE id=? ";
        int rowsUpdated = jdbcTemplate.update(sql, wall.getCragId(), wall.getName(),
                wall.getDescription(), wall.getId());
        return rowsUpdated==1;
    }

    @Override
    public boolean deleteWall(String id) {
        String sql = "DELETE FROM walls " +
                "WHERE id = ?";
        int rowsDeleted = jdbcTemplate.update(sql, id);
        return rowsDeleted==1;
    }

    private Wall mapRowToWall(SqlRowSet results){
        String id = results.getString("id");
        String cragId=results.getString("crag_id");
        String name=results.getString("name");
        String description=results.getString("description");
        return new Wall(id,cragId,name,description);
    }
}
