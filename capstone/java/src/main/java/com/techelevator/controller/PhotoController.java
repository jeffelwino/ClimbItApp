package com.techelevator.controller;

import com.techelevator.model.Picture;
import com.techelevator.services.CloudinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PhotoController {
    @Autowired
    CloudinaryService cloudinaryService;


//    @RequestMapping(path="/test", method= RequestMethod.GET)
//    public List<Picture> test(@RequestParam String query) {
//
//
//        return CloudinaryService.getSearchResults(query);
//
//    }

}
