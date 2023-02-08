package com.techelevator.dao.locations;

import com.techelevator.model.locations.Area;

import java.util.List;

public interface AreaDao {
//    CRUD
//    CREATE
    Area addArea(Area area);
//    READ
    List<Area> getAllAreas();
    Area getAreaById(String id);
    List<Area> getAreasByState(String abbrev);
//    UPDATE
    boolean updateArea(Area area);
//    DELETE
    boolean deleteArea(String id);
}
