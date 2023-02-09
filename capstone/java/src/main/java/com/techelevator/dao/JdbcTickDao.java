package com.techelevator.dao;

import com.techelevator.model.Tick;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcTickDao implements TickDao{
    private JdbcTemplate jdbcTemplate;

    public JdbcTickDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Tick addTick(Tick tick) {
        String sql = "INSERT INTO ticks (route_id, profile_id, date_climbed, note, rating) " +
                "VALUES (?,?,?,?,?) " +
                "RETURNING tick_id";
        Integer id = jdbcTemplate.queryForObject(sql, Integer.class, tick.getRouteId(),
                tick.getProfileId(), tick.getDate(),tick.getNote(),tick.getRating());
        return getTickById(id);
    }

    @Override
    public List<Tick> getTicksByRoute(String routeId){
        List<Tick> ticks = new ArrayList<>();
        String sql = "SELECT tick_id, route_id, profile_id, date_climbed, note, rating " +
                "FROM ticks WHERE route_id ILIKE ? ORDER BY date_climbed DESC ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, routeId);
        while(results.next()){
            ticks.add(mapRowToTick(results));
        }
        return ticks;
    }
    @Override
    public List<Tick> getTicksByProfile(int profileId){
        List<Tick> ticks = new ArrayList<>();
        String sql = "SELECT tick_id, route_id, profile_id, date_climbed, note, rating " +
                "FROM ticks where profile_id = ? ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, profileId);
        while(results.next()){
            ticks.add(mapRowToTick(results));
        }
        return ticks;

    }

    public Tick getTickById(int tickId) {
        Tick tick = null;
        String sql = "SELECT tick_id, route_id, profile_id, date_climbed, note, rating " +
                "FROM ticks " +
                "WHERE tick_id=?";
        SqlRowSet results= jdbcTemplate.queryForRowSet(sql, tickId);
        if(results.next()){
            tick=mapRowToTick(results);
        }
        return tick;
    }

    @Override
    public boolean updateTick(Tick tick) {
        String sql = "UPDATE ticks " +
                "SET route_id=?, profile_id=?, date_climbed=?, note=?, rating=? " +
                "WHERE tick_id=?";
        int rowsUpdated = jdbcTemplate.update(sql, tick.getRouteId(), tick.getProfileId(),
                tick.getDate(),tick.getNote(),tick.getRating(), tick.getId());
        return rowsUpdated==1;
    }

    @Override
    public boolean deleteTick(int tickId) {
        String sql = "DELETE FROM ticks " +
                "WHERE tick_id=?";
        int rowsDeleted=jdbcTemplate.update(sql, tickId);
        return rowsDeleted==1;
    }

    private Tick mapRowToTick(SqlRowSet results){
        int tickId=results.getInt("tick_id");
        String routeId=results.getString("route_id");
        int profileId=results.getInt("profile_id");
        LocalDate date=null;
        if(results.getDate("date_climbed") != null){
            date=results.getDate("date_climbed").toLocalDate();
        }
        String note=results.getString("note");
        int rating=results.getInt("rating");
        return new Tick(tickId,routeId,profileId,date,note,rating);
    }
}
