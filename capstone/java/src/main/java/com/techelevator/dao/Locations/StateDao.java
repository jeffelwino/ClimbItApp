package com.techelevator.dao.locations;

import com.techelevator.model.locations.State;

import java.util.List;

public interface StateDao {
//    CRUD
//    CREATE
//    READ
    List<State> getAllStates();
    State getStateByAbbrev(String abbrev);
//    UPDATE
//    DELETE
}
