package com.techelevator.controller;

import com.techelevator.dao.locations.PhotoDao;
import com.techelevator.model.locations.Photo;
import com.techelevator.services.CloudinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class PhotoController {
    @Autowired
    CloudinaryService cloudinaryService;
    @Autowired
    private PhotoDao photoDao;

    @GetMapping(path="/route/{id}/photos")
    public List<Photo> getAllPhotosByRouteId(@PathVariable String id) {
        return photoDao.getAllPhotosByRouteId(id);

    }
    @GetMapping(path="/profile/{id}/photos")
    public List<Photo> getAllPhotosByProfileId(@PathVariable String id) {
        return photoDao.getAllPhotosByProfileId(id);
    }

    @GetMapping(path="/photo/{id}")
    public Photo getPhotoById(@PathVariable String id) {
        return photoDao.getPhotoById(id);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path="/photo/add")
    public Photo addPhoto(@RequestBody Photo photo) {
        return photoDao.addPhoto(photo);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path="/photo/{id}")
    public boolean deletePhoto(@RequestBody String id){
        return photoDao.deletePhoto(id);
    }
}
