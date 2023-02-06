package com.techelevator.dao.Locations;

import com.techelevator.model.State;

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
