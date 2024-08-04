package com.to_do_app.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.to_do_app.model.Todo;
import com.to_do_app.service.TodoService;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

	@Autowired
	private TodoService todoService;

	@PostMapping
	public ResponseEntity<?> createTodos(@RequestBody Todo todo) {
		Todo todoExist = todoService.getTodoByTitle(todo.getTitle());

		if (todoExist != null) {

			Map<String, String> response = new HashMap<>();
			response.put("message", "Already exists with the same title");
			return new ResponseEntity<>(response, HttpStatus.CONFLICT);
		}
		Todo newTodo = todoService.createNewTodo(todo);
		return new ResponseEntity<>(newTodo, HttpStatus.CREATED);

	}

}
