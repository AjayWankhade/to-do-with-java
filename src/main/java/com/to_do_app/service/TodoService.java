package com.to_do_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.to_do_app.model.Todo;
import com.to_do_app.repository.TodoRepo;

import jakarta.transaction.Transactional;

@Service
public class TodoService {

	@Autowired
	private TodoRepo todoRepo;

	@Transactional
	public Todo createNewTodo(Todo todo) {
		return todoRepo.save(todo);
	}

	@Transactional
	public List<Todo> getTodosByTitle(String title) {
		return todoRepo.findByTitle(title);
	}

	@Transactional
	public List<Todo> getAllTodos() {
		return todoRepo.findAll();
	}

	@Transactional
	public Todo updateTodo(Long id, Todo todo) {
		Optional<Todo> existingTodo = todoRepo.findById(id);

		if (existingTodo.isPresent()) {
			Todo updatedTodo = existingTodo.get();

			updatedTodo.setTitle(todo.getTitle());
			updatedTodo.setDescription(todo.getDescription());
			updatedTodo.setTargetDate(todo.getTargetDate());

			return todoRepo.save(updatedTodo);
		} else {
			throw new RuntimeException("Todo not found with id " + id);
		}
	}

}
