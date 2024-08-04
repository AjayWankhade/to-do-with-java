package com.to_do_app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.to_do_app.model.Todo;

@Repository
public interface TodoRepo extends JpaRepository<Todo, Long> {

	

	List<Todo> findAll();
	@Query("SELECT t FROM Todo t WHERE t.title = ?1")
	List<Todo> findByTitle(String title);

	

}
