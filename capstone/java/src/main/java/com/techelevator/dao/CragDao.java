package com.techelevator.dao;

import com.techelevator.model.Crag;

import java.util.List;

public interface CragDao {
//    CRUD
//    CREATE
    Crag addCrag(Crag crag);
//    READ
    List<Crag> getAllCrags();
    Crag getCragById(String id);
//    UPDATE
    boolean updateCrag(Crag crag);
//    DELETE
    boolean deleteCrag(String id);
}
