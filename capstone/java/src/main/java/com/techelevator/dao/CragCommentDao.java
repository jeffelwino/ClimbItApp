package com.techelevator.dao;

import com.techelevator.model.Comment;
import com.techelevator.model.CragComment;

import java.util.List;

public interface CragCommentDao {
//    CRUD
//    CREATE
    CragComment addComment(CragComment comment);
//    READ
    List<CragComment> getAllCragComments();

    Comment getCommentById(int id);
//    UPDATE
//    DELETE
}
