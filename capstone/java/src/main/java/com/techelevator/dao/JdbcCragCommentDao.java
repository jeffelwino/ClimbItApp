package com.techelevator.dao;

import com.techelevator.model.CragComment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcCragCommentDao implements CragCommentDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcCragCommentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public CragComment addCragComment(CragComment comment) {
        String sql = "INSERT INTO crag_comments (body, profile_id, post_date, crag_id) " +
                "VALUES (?,?,?,?) " +
                "RETURNING comment_id";
        Integer id = jdbcTemplate.queryForObject(sql, Integer.class, comment.getBody(),comment.getProfileId(),comment.getPostDate(), comment.getCragId());
        return getCragCommentById(id);
    }

    @Override
    public List<CragComment> getAllCragComments(String cragId) {
        List<CragComment> comments = new ArrayList<>();
        String sql = "SELECT comment_id, body, profile_id, post_date, crag_id " +
                "FROM crag_comments WHERE crag_id = ? ORDER BY post_date DESC ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, cragId);
        while(results.next()){
            comments.add(mapRowToComment(results));
        }
        return comments;
    }

    @Override
    public CragComment getCragCommentById(int id) {
        CragComment comment = null;
        String sql = "SELECT comment_id, body, profile_id, post_date, crag_id " +
                "FROM crag_comments " +
                "WHERE comment_id=?";
        SqlRowSet results= jdbcTemplate.queryForRowSet(sql, id);
        if(results.next()){
            comment = mapRowToComment(results);
        }
        return comment;
    }

    private CragComment mapRowToComment(SqlRowSet results){
        int commentId=results.getInt("comment_id");
        String body=results.getString("body");
        int profileId=results.getInt("profile_id");
        LocalDate postDate=null;
        if(results.getDate("post_date") != null){
            postDate = results.getDate("post_date").toLocalDate();
        }
        String cragId = results.getString("crag_id");

        return new CragComment(commentId,body,profileId,postDate,cragId);
    }
}
