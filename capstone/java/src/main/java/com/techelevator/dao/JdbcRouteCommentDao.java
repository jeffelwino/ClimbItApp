package com.techelevator.dao;

import com.techelevator.model.CragComment;
import com.techelevator.model.RouteComment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcRouteCommentDao implements RouteCommentDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcRouteCommentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public RouteComment addRouteComment(RouteComment comment) {
        String sql = "INSERT INTO route_comments (body, profile_id, post_date, route_id) " +
                "VALUES (?,?,?,?) " +
                "RETURNING comment_id";
        Integer id = jdbcTemplate.queryForObject(sql, Integer.class, comment.getBody(),comment.getProfileId(),comment.getPostDate(), comment.getRouteId());
        return getRouteCommentById(id);
    }

    @Override
    public List<RouteComment> getAllRouteComments(String routeId) {
        List<RouteComment> comments = new ArrayList<>();
        String sql = "SELECT comment_id, body, profile_id, post_date, route_id " +
                "FROM route_comments WHERE route_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, routeId);
        while(results.next()){
            comments.add(mapRowToComment(results));
        }
        return comments;
    }

    @Override
    public RouteComment getRouteCommentById(int id) {
        RouteComment comment = null;
        String sql = "SELECT comment_id, body, profile_id, post_date, route_id " +
                "FROM route_comments " +
                "WHERE comment_id=?";
        SqlRowSet results= jdbcTemplate.queryForRowSet(sql, id);
        if(results.next()){
            comment = mapRowToComment(results);
        }
        return comment;
    }

    private RouteComment mapRowToComment(SqlRowSet results){
        int commentId=results.getInt("comment_id");
        String body=results.getString("body");
        int profileId=results.getInt("profile_id");
        LocalDate postDate=null;
        if(results.getDate("post_date") != null){
            postDate = results.getDate("post_date").toLocalDate();
        }
        String routeId = results.getString("route_id");

        return new RouteComment(commentId,body,profileId,postDate,routeId);
    }
}
