package com.to_do_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.to_do_app.model.Todo;


@Repository
public interface TodoRepo extends JpaRepository<Todo, Long> {
	

}
