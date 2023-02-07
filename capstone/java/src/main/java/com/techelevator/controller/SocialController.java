package com.techelevator.controller;


import com.techelevator.dao.CommentDao;
import com.techelevator.dao.JdbcCommentDao;
import com.techelevator.dao.JdbcProfileDao;
import com.techelevator.dao.JdbcUserDao;
import com.techelevator.model.Comment;
import com.techelevator.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SocialController {
    
    @Autowired
    private CommentDao;
    @Autowired
    private JdbcProfileDao jdbcProfileDao;
    @Autowired
    private JdbcUserDao jdbcUserDao;



    @RequestMapping(path="/comment", method = RequestMethod.POST)
    public Comment addComment(@RequestBody Comment comment){
        return comment;
    }

    @RequestMapping(path="/", method = RequestMethod.GET)
    public List<Comment> getAllComments(){
        return jdbcCommentDao.getAllComments();
    }

    @RequestMapping(path="/{id}", method = RequestMethod.GET)
    public Comment getCommentById(@PathVariable int id){
        Comment comment = jdbcCommentDao.getCommentById(id);
        return comment;
    }

    @RequestMapping(path="", method = RequestMethod.GET)
    public int findIdByUsername(@PathVariable String username){
        return jdbcUserDao.findIdByUsername(username);
    }

    @RequestMapping(path="", method = RequestMethod.GET)
    public User getUserById(int userId){

    }



}
