package com.techelevator.dao;

import com.techelevator.model.Comment;
import com.techelevator.model.CragComment;
import com.techelevator.model.locations.Crag;

import java.util.List;

public interface CragCommentDao {
//    CRUD
//    CREATE
    CragComment addComment(CragComment comment);
//    READ
    List<CragComment> getAllCragComments();

    CragComment getCommentById(int id);
//    UPDATE
//    DELETE
}
