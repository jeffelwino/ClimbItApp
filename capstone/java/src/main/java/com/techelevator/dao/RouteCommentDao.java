package com.techelevator.dao;

import com.techelevator.model.Comment;
import com.techelevator.model.CragComment;
import com.techelevator.model.RouteComment;

import java.util.List;

public interface RouteCommentDao {
    //    CRUD
    //    CREATE
    RouteComment addComment(RouteComment comment);
    //    READ
    List<RouteComment> getAllRouteComments();
    RouteComment getCommentById(int id);
    //    UPDATE
    //    DELETE
}
