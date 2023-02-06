package com.techelevator.dao.Locations;

import com.techelevator.model.Wall;

import java.util.List;

public interface WallDao {
//    CRUD
//    CREATE
    Wall addWall(Wall wall);
//    READ
    List<Wall> getAllWalls();
    Wall getWallById(String id);
//    UPDATE
    boolean updateWall(Wall wall);
//    DELETE
    boolean deleteWall(String id);
}
