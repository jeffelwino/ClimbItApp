package com.techelevator.dao;

import com.techelevator.model.Tick;

import java.util.List;

public interface TickDao {
//    CRUD
//    CREATE
    Tick addTick(Tick tick);
//    READ
    List<Tick> getTicksByRoute(String routeId);
    List<Tick> getTicksByProfile(int profileId);
//    UPDATE
    boolean updateTick(Tick tick);
//    DELETE
    boolean deleteTick(int tickId);
}
