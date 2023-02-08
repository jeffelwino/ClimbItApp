package com.techelevator.services;


import com.techelevator.model.Picture;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CloudinaryService {

    @Value("${cloudinary.api.url}")
    private String apiURL;

    @Value("${cloudinary.api.key}")
    private String apiKey;

    @Value("${cloudinary.api.cloudname}")
    private String cloudName;

    @Value("${cloudinary.api.secret}")
    private String secret;

    List<Picture> getProfilePictures(String searchString){
        String url = this.apiURL + this.cloudName + searchString;
        List<Picture> pictures = new ArrayList<>();




        return pictures;
    }




}
