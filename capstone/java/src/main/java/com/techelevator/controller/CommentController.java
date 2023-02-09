package com.techelevator.controller;

import com.techelevator.dao.CragCommentDao;
import com.techelevator.dao.RouteCommentDao;
import com.techelevator.model.Comment;
import com.techelevator.model.CragComment;
import com.techelevator.model.RouteComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
public class CommentController {
    @Autowired
    private CragCommentDao cragCommentDao;
    @Autowired
    private RouteCommentDao routeCommentDao;


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path="/crag/comment")
    public Comment addCragComment(@RequestBody CragComment comment){
        return cragCommentDao.addCragComment(comment);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path="/route/comment")
    public RouteComment addRouteComment(@RequestBody RouteComment comment){
        return routeCommentDao.addRouteComment(comment);
    }

    @GetMapping(path="/crag/{id}/comments")
    public List<CragComment> getAllCragComments(@PathVariable String id){
        return cragCommentDao.getAllCragComments(id);
    }
    
    @GetMapping(path="/route/{id}/comments")
    public List<RouteComment> getAllRouteComments(@PathVariable String id){
        return routeCommentDao.getAllRouteComments(id);
    }

    @GetMapping(path="/crag/comment/{id}")
    public CragComment getCragCommentById(@PathVariable int id){
        return cragCommentDao.getCragCommentById(id);
    }
    @GetMapping(path="/route/comment/{id}")
    public RouteComment getRouteCommentById(@PathVariable int id){
        return routeCommentDao.getRouteCommentById(id);
    }

}
