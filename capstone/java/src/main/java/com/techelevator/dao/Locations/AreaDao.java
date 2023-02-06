package com.techelevator.dao.Locations;

import com.techelevator.model.Area;

import java.util.List;

public interface AreaDao {
//    CRUD
//    CREATE
    Area addArea(Area area);
//    READ
    List<Area> getAllAreas();
    Area getAreaById(String id);
//    UPDATE
    boolean updateArea(Area area);
//    DELETE
    boolean deleteArea(String id);
}
