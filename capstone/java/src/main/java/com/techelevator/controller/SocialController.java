package com.techelevator.controller;


import com.techelevator.dao.*;
import com.techelevator.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class SocialController {
    
    @Autowired
    private CragCommentDao cragCommentDao;
    @Autowired
    private RouteCommentDao routeCommentDao;
    @Autowired
    private ProfileDao profileDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private TickDao tickDao;
    @Autowired
    private TodoDao todoDao;


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path="/comment")
    public Comment addComment(@RequestBody CragComment comment){
        return cragCommentDao.addComment(comment);
    }


    @GetMapping(path="/comment/crag")
    public List<CragComment> getAllCragComments(){
        return cragCommentDao.getAllCragComments();
    }
    @GetMapping(path="/comment/route")
    public List<RouteComment> getAllRouteComments(){
        return routeCommentDao.getAllRouteComments();
    }

    @GetMapping(path="/comment/{id}")
    public Comment getCommentById(@PathVariable int id){
        Comment comment = cragCommentDao.getCommentById(id);
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

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path="/tick")
    public Tick addTick(@RequestBody Tick tick){
        return tickDao.addTick(tick);
    }

    @GetMapping(path="/tick")
    public List<Tick> getAllTicks(){
        return tickDao.getAllTicks();
    }

    @GetMapping(path="/tick/{tickId}")
    public Tick getTickById(@PathVariable int tickId){
        return tickDao.getTickById(tickId);
    }

    @PutMapping(path="/tick")
    public boolean updateTick(@RequestBody Tick tick){
        return tickDao.updateTick(tick);
    }

    @DeleteMapping(path="/tick/{tickId}")
    public boolean deleteTick(@PathVariable int tickId){
        return tickDao.deleteTick(tickId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path="/todo")
    public Todo addTodo(@RequestBody Todo todo){
        return todoDao.addTodo(todo);
    }

    @GetMapping(path="/todo")
    public List<Todo> getAllTodos(){
        return todoDao.getAllTodos();
    }

    @GetMapping(path="/todo/{profileId}")
    public List<Todo> getTodosByUser(@PathVariable int profileId){
        return todoDao.getTodosByUser(profileId);
    }

    @GetMapping(path="/todo/{id}")
    public Todo getTodoById(@PathVariable int id){
        return todoDao.getTodoById(id);
    }

    @DeleteMapping(path="/todo/{id}")
    public boolean deleteTodo(@PathVariable int id){
        return todoDao.deleteTodo(id);
    }

}
