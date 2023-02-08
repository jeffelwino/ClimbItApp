package com.techelevator.dao.locations;

import com.techelevator.model.locations.Crag;

import java.util.List;

public interface CragDao {
//    CRUD
//    CREATE
    Crag addCrag(Crag crag);
//    READ
    List<Crag> getAllCrags();
    Crag getCragById(String id);
    List<Crag> getCragsByAreaId(String id);
//    UPDATE
    boolean updateCrag(Crag crag);
//    DELETE
    boolean deleteCrag(String id);
}
