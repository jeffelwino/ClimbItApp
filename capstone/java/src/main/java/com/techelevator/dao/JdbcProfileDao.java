package com.techelevator.dao;

import com.techelevator.model.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcProfileDao implements ProfileDao{
    private JdbcTemplate jdbcTemplate;

    public JdbcProfileDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

//    @Override
//    public Profile addProfile(Profile profile) {
//        String sql = "INSERT INTO profiles (user_id, name, picture_id, location, bio) " +
//                "VALUES (?,?,?,?,?) " +
//                "RETURNING profile_id";
//        Integer profileId=jdbcTemplate.queryForObject(sql, Integer.class, profile.getUserId(),
//                profile.getName(),profile.getPictureId(),profile.getLocation(),profile.getBio());
//        return getProfileById(profileId);
//    }

    @Override
    public List<Profile> getAllProfiles() {
        List<Profile> profiles = new ArrayList<>();
        String sql = "SELECT profile_id, user_id, name, location, bio, picture_id " +
                "FROM profiles ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            profiles.add(mapRowToProfile(results));
        }
        return profiles;
    }

    @Override
    public Profile getProfileById(int id) {
        Profile profile = null;
        String sql = "SELECT profile_id, user_id, name, picture_id, location, bio " +
                "FROM profiles " +
                "WHERE profile_id=?";
        SqlRowSet results= jdbcTemplate.queryForRowSet(sql,id);
        if(results.next()){
            profile=mapRowToProfile(results);
        }
        return profile;
    }

    @Override
    public boolean updateProfile(Profile profile) {
        String sql = "UPDATE profiles " +
                "SET name=?, picture_id=?, location=?, bio=? " +
                "WHERE profile_id =?";
        int rowsUpdated =  jdbcTemplate.update(sql, profile.getName(),profile.getPictureId(),profile.getLocation(),profile.getBio(), profile.getId());
        return rowsUpdated==1;
    }

    @Override
    public boolean deleteProfile(int id) {
        String sql = "DELETE FROM profiles " +
                "WHERE profile_id=?";
        int rowsDeleted = jdbcTemplate.update(sql, id);
        return rowsDeleted==1;
    }

    private Profile mapRowToProfile(SqlRowSet results){
        int profileId=results.getInt("profile_id");
        int userId=results.getInt("user_id");
        String name=results.getString("name");
        String pictureId=results.getString("picture_id");
        String location=results.getString("location");
        String bio=results.getString("bio");
        return new Profile(profileId,userId,name,pictureId,location,bio);
    }
}
