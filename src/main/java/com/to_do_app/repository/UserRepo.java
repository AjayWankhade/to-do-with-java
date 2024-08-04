package com.to_do_app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.to_do_app.model.User;

import jakarta.transaction.Transactional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
	
	public User findByFirstName(String name);
	public List<User> findAll();	
	
	
	Optional<User> findUserById(Long id);
	
	Optional<User> findById(Long id);

}
