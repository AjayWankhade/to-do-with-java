package com.to_do_app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.to_do_app.model.Todo;
import com.to_do_app.service.TodoService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

	@Autowired
	private TodoService todoService;

	@PostMapping
	public ResponseEntity<?> createTodos(@RequestBody Todo todo) {
		List<Todo> todosExist = todoService.getTodosByTitle(todo.getTitle());

		if (!todosExist.isEmpty()) {
			Map<String, String> response = new HashMap<>();
			response.put("message", "Already exists with the same title");
			return new ResponseEntity<>(response, HttpStatus.CONFLICT);
		}
		Todo newTodo = todoService.createNewTodo(todo);
		return new ResponseEntity<>(newTodo, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Todo>> getAllTodos() {
		List<Todo> todos = todoService.getAllTodos();
		return new ResponseEntity<>(todos, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public Todo putTodo(@PathVariable Long id, @RequestBody Todo todo) {

		return todoService.updateTodo(id, todo);
	}

}
