package com.techelevator.dao;

import com.techelevator.model.Comment;

import java.util.List;

public interface CommentDao {
//    CRUD
//    CREATE
    Comment addComment(Comment comment);
//    READ
    List<Comment> getAllComments();
    Comment getCommentById(int id);
//    UPDATE
//    DELETE
}
