package com.techelevator.dao;

import com.techelevator.model.Comment;
import com.techelevator.model.CragComment;
import com.techelevator.model.RouteComment;

import java.util.List;

public interface RouteCommentDao {
    //    CRUD
    //    CREATE
    RouteComment addRouteComment(RouteComment comment);
    //    READ
    List<RouteComment> getAllRouteComments(String routeId);
    RouteComment getRouteCommentById(int id);
    //    UPDATE
    //    DELETE
}
