package com.techelevator.dao;

import com.techelevator.model.Todo;

import java.util.List;

public interface TodoDao {
//    CRUD
//    CREATE
    Todo addTodo(Todo todo);
//    READ
    List<Todo> getAllTodos();
    List<Todo> getTodosByUser(int profileId);
    Todo getTodoById(int id);
//    Update
//    Delete
    boolean deleteTodo(int id);
}
