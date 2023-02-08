package com.techelevator.controller;


import com.techelevator.dao.*;
import com.techelevator.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin
public class SocialController {

    @Autowired
    private ProfileDao profileDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private TickDao tickDao;
    @Autowired
    private TodoDao todoDao;


    @GetMapping(path="/profile")
    public List<Profile> getAllProfiles(){
        return profileDao.getAllProfiles();
    }


    @GetMapping(path="/profile/{id}")
    public Profile getProfileById(@PathVariable int id) {
        Profile result = profileDao.getProfileById(id);
        if(result == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No profile with that id.");
        }
        else{
            return result;
        }
    }

    @PutMapping(path="/profile")
    public boolean updateProfile(@RequestBody Profile profile){
        return profileDao.updateProfile(profile);
    }

    //this is causing an issue because the profile is referenced in the tick table
    //as well.
    @DeleteMapping(path="/profile/{id}")
    public boolean deleteProfile(@PathVariable int id){
        return profileDao.deleteProfile(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path="/tick")
    public Tick addTick(@RequestBody Tick tick){
        return tickDao.addTick(tick);
    }

    @GetMapping(path="/profile/{id}/ticks")
    public List<Tick> getTicksByProfile(@PathVariable int id){
        return tickDao.getTicksByProfile(id);
    }

    @GetMapping(path="route/{id}/ticks")
    public List<Tick> getTicksByRoute(@PathVariable String id){
        return tickDao.getTicksByRoute(id);
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

    @GetMapping(path="profile/{profileId}/todo")
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
