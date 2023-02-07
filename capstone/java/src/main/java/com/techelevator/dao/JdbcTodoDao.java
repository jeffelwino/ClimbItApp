package com.techelevator.dao;

import com.techelevator.model.Todo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcTodoDao implements TodoDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcTodoDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Todo addTodo(Todo todo) {
        String sql = "INSERT INTO todos (profile_id, route_id) " +
                "VALUES (?,?) " +
                "RETURNING profile_id";
        Integer id = jdbcTemplate.queryForObject(sql, Integer.class, todo.getProfileId(), todo.getRouteId());
        return getTodoById(id);
    }

    @Override
    public List<Todo> getAllTodos() {
        List<Todo> todos = new ArrayList<>();
        String sql = "SELECT todo_id, profile_id, route_id " +
                "FROM todos";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            todos.add(mapRowToTodo(results));
        }
        return todos;
    }

    @Override
    public List<Todo> getTodosByUser(int profileId) {
        List<Todo> todos = new ArrayList<>();
        String sql = "SELECT todo_id, profile_id, route_id " +
                "FROM todos " +
                "WHERE profile_id=?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, profileId);
        while(results.next()){
            todos.add(mapRowToTodo(results));
        }
        return todos;
    }

    @Override
    public Todo getTodoById(int id) {
        Todo todo = null;
        String sql = "SELECT todo_id, profile_id, route_id " +
                "FROM todos " +
                "WHERE todo_id=?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if(results.next()){
            todo=mapRowToTodo(results);
        }
        return todo;
    }

    @Override
    public boolean deleteTodo(int id) {
        String sql = "DELETE FROM todos " +
                "WHERE todo_id=?";
        int rowsDeleted = jdbcTemplate.update(sql,id);
        return rowsDeleted==1;
    }

    Todo mapRowToTodo(SqlRowSet results){
        int todoId=results.getInt("todo_id");
        int profileId=results.getInt("profile_id");
        String routeId=results.getString("route_id");
        return new Todo(todoId,profileId,routeId);
    }
}
