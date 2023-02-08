package com.techelevator.dao.locations;

import com.techelevator.model.locations.Wall;

import java.util.List;

public interface WallDao {
//    CRUD
//    CREATE
    Wall addWall(Wall wall);
//    READ
    List<Wall> getAllWalls();
    List<Wall> getWallsByCragId(String id);
    Wall getWallById(String id);
//    UPDATE
    boolean updateWall(Wall wall);
//    DELETE
    boolean deleteWall(String id);
}
