package com.to_do_app.service;

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
	public Todo getTodoByTitle(String title) {
		
		return todoRepo.getTodoByTitle(title);
	}
}
