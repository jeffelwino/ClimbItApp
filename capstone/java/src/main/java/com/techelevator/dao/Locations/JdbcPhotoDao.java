package com.techelevator.dao.locations;

import com.techelevator.model.locations.Photo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcPhotoDao implements PhotoDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcPhotoDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public Photo addPhoto(Photo photo){
     String sql = "INSERT into shared_images (image_id, route_id) " +
             "VALUES (?,?) " +
             "RETURNING image_id ";
     String id = jdbcTemplate.queryForObject(sql, String.class, photo.getPhotoId(), photo.getRouteId());
     return getPhotoById(id);
    }

    @Override
    public List<Photo> getAllPhotosByRouteId(String id) {
        List<Photo> photos = new ArrayList<>();
        String sql = "SELECT image_id, route_id " +
                "FROM shared_images WHERE route_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        while(results.next()){
            photos.add(mapRowToPhoto(results));
        }
        return photos;
    }

    @Override
    public List<Photo> getAllPhotosByProfileId(String profileid) {
        List<Photo> photos = new ArrayList<>();
        String sql = "SELECT image_id, route_id " +
                "FROM shared_images WHERE profile_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, profileid);
        while(results.next()){
            photos.add(mapRowToPhoto(results));
        }
        return photos;
    }

    @Override
    public Photo getPhotoById(String imageId) {
        Photo photo = null;
        String sql = "SELECT image_id, route_id " +
                "FROM shared_images WHERE image_id = ?";
        SqlRowSet results= jdbcTemplate.queryForRowSet(sql, imageId);
        if(results.next()){
            photo = mapRowToPhoto(results);
        }
        return photo;
    }

    @Override
    public boolean deletePhoto(String imageId) {
        String sql = "DELETE from shared_images " +
                "WHERE image_id = ?";
        int deletedRows = jdbcTemplate.update(sql, imageId);
        return deletedRows==1;
    }
    private Photo mapRowToPhoto(SqlRowSet results){
        String photoId = results.getString("image_id");
        String routeId = results.getString("route_id");
        return new Photo(photoId, routeId);
    }
}
