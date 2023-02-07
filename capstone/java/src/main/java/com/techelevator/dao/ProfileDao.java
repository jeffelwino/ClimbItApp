package com.techelevator.dao;

import com.techelevator.model.Profile;

import java.util.List;

public interface ProfileDao {
//    CRUD
//    CREATE
    Profile addProfile(Profile profile);
//    READ
    List<Profile> getAllProfiles();
    Profile getProfileById(int id);
//    UPDATE
    boolean updateProfile(Profile profile);
//    DELETE
    boolean deleteProfile(int id);
}
