package com.techelevator.dao;

import com.techelevator.model.Comment;
import com.techelevator.model.CragComment;
import com.techelevator.model.locations.Crag;

import java.util.List;

public interface CragCommentDao {
//    CRUD
//    CREATE
    CragComment addCragComment(CragComment comment);
//    READ
    List<CragComment> getAllCragComments(String cragId);

    CragComment getCragCommentById(int id);
//    UPDATE
//    DELETE
}
