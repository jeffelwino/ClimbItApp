package com.techelevator.controller;


import com.techelevator.dao.*;
import com.techelevator.model.Comment;
import com.techelevator.model.Profile;
import com.techelevator.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class SocialController {
    
    @Autowired
    private CommentDao commentDao;
    @Autowired
    private ProfileDao profileDao;
    @Autowired
    private UserDao userDao;



    @PostMapping(path="/comment")
    public Comment addComment(@RequestBody Comment comment){
        return commentDao.addComment(comment);
    }

    @GetMapping(path="/comment")
    public List<Comment> getAllComments(){
        return commentDao.getAllComments();
    }

    @GetMapping(path="/comment/{id}")
    public Comment getCommentById(@PathVariable int id){
        Comment comment = commentDao.getCommentById(id);
        return comment;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path="/profile")
    public Profile addProfile(@RequestBody Profile profile){
        return profileDao.addProfile(profile);
    }

    @GetMapping(path="/profile")
    public List<Profile> getAllProfiles(){
        return profileDao.getAllProfiles();
    }

    @GetMapping(path="/profile/{id}")
    public Profile getProfileById(@PathVariable int id){
        return profileDao.getProfileById(id);
    }

    @PutMapping(path="/profile")
    public boolean updateProfile(@RequestBody Profile profile){
        return profileDao.updateProfile(profile);
    }

    @DeleteMapping(path="/profile/{id}")
    public boolean deleteProfile(@PathVariable int id){
        return profileDao.deleteProfile(id);
    }


}
