package com.techelevator.dao.locations;

import com.techelevator.model.ProfilePhotoDto;
import com.techelevator.model.locations.Photo;

import java.util.List;

public interface PhotoDao {
    //CRUD
    //CREATE
    Photo addPhoto(Photo photo);
    //READ
    List<Photo> getAllPhotosByRouteId(String id);
    List<Photo> getAllPhotosByProfileId(String profileId); //<---Not sure if we will use this
    Photo getPhotoById(String imageId); //<---Not sure if we will use this
    List<Photo> getAllPhotosByWallId(String id);
    //UPDATE
    boolean updateProfilePhoto(ProfilePhotoDto profilePhotoDto);
    //DELETE
    boolean deletePhoto(String imageId); //ADMIN only for this one-ADMIN can delete any photo
}
