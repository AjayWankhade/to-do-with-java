package com.to_do_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.to_do_app.model.User;
import com.to_do_app.repository.UserRepo;

import jakarta.transaction.Transactional;

@Service
public class UserService {
	@Autowired
	private UserRepo userRepo;

	@Transactional
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	@Transactional
	public Optional<User> getUserById(Long id) {
		return userRepo.findById(id);
	}

	@Transactional
	public User getUserByName(String firstName) {

		return userRepo.findByFirstName(firstName);
	}

	@Transactional
	public User createNewUser(User user) {
		return userRepo.save(user);
	}

	@Transactional
	public User updateUserById(Long id, User user) {

		User existingUser = userRepo.findById(id)
				.orElseThrow(() -> new RuntimeException("User not found with id " + id));

		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setUserName(user.getUserName());
		existingUser.setPassword(user.getPassword());

		User savedUser = userRepo.save(existingUser);
		System.out.println("Updated user: " + savedUser);
		return savedUser;
	}

	@Transactional
	public void deleteUser(Long id) throws Exception {
		try {
			userRepo.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new Exception("Event not found with id: " + id);
		}
	}

}
