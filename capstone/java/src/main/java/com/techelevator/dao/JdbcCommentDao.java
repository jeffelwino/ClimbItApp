package com.techelevator.dao;

import com.techelevator.model.Comment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcCommentDao implements CommentDao{
    private JdbcTemplate jdbcTemplate;

    public JdbcCommentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Comment addComment(Comment comment) {
        String sql = "INSERT INTO comments (body, profile_id, post_date, subject_id) " +
                "VALUES (?,?,?,?) " +
                "RETURNING comment_id";
        Integer id = jdbcTemplate.queryForObject(sql, Integer.class, comment.getBody(),comment.getProfileId(),comment.getPostDate(),comment.getSubjectId());
        return getCommentById(id);
    }

    @Override
    public List<Comment> getAllComments() {
        List<Comment> comments = new ArrayList<>();
        String sql = "SELECT comment_id, body, profile_id, post_date, subject_id " +
                "FROM comments ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            comments.add(mapRowToComment(results));
        }
        return comments;
    }

    @Override
    public List<Comment> getAllCragComments() {
        List<Comment> comments = new ArrayList<>();
        String sql = "SELECT com.comment_id, body, profile_id, post_date, route_id " +
                "FROM comments com " +
                "JOIN comment_crag c_c on c_c.comment_id = com.comment_id ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            comments.add(mapRowToComment(results));
        }
        return comments;
    }

    @Override
    public List<Comment> getAllRouteComments() {
        List<Comment> comments = new ArrayList<>();
        String sql = "SELECT com.comment_id, body, profile_id, post_date, route_id " +
                "FROM comments com " +
                "JOIN comment_route c_r  on c_r.comment_id = com.comment_id";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            comments.add(mapRowToComment(results));
        }
        return comments;
    }

    @Override
    public Comment getCommentById(int id) {
        Comment comment = null;
        String sql = "SELECT comment_id, body, profile_id, post_date, subject_id " +
                "FROM comments " +
                "WHERE comment_id=?";
        SqlRowSet results= jdbcTemplate.queryForRowSet(sql, id);
        if(results.next()){
            comment = mapRowToComment(results);
        }
        return comment;
    }

    private Comment mapRowToComment(SqlRowSet results){
        int commentId=results.getInt("comment_id");
        String body=results.getString("body");
        int profileId=results.getInt("profile_id");
        LocalDate postDate=null;
        if(results.getDate("post_date") != null){
            postDate = results.getDate("post_date").toLocalDate();
        }
        String subjectId = null;
        try {
            subjectId = results.getString("crag_id");
        } catch(Exception e){
            subjectId = results.getString("route_id");
        }

        return new Comment(commentId,body,profileId,postDate,subjectId);
    }
}
