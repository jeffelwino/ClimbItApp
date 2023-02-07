package com.techelevator.dao.locations;

import com.techelevator.model.locations.State;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcStateDao implements StateDao{
    private JdbcTemplate jdbcTemplate;

    public JdbcStateDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<State> getAllStates() {
        List<State> states = new ArrayList<>();
        String sql = "SELECT abbrev, state_name, latitude, longitude " +
                "FROM states ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            states.add(mapRowToState(results));
        }
        return states;
    }

    @Override
    public State getStateByAbbrev(String abbrev) {
        State state = null;
        String sql = "SELECT abbrev, state_name, latitude, longitude " +
                "FROM states " +
                "WHERE state_abbrev=?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql,abbrev);
        if(results.next()){
            state=mapRowToState(results);
        }
        return state;
    }

    State mapRowToState(SqlRowSet results){
        String stateAbbrev = results.getString("abbrev");
        String stateName = results.getString("state_name");
        double latitude=results.getDouble("latitude");
        double longitude=results.getDouble("longitude");
        return new State(stateAbbrev,stateName, latitude, longitude);
    }
}
