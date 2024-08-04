package com.to_do_app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.to_do_app.model.User;
import com.to_do_app.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> users=userService.getAllUsers();
		if(users.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		else {
			return new ResponseEntity<>(users,HttpStatus.FOUND);
		}
	}
	

	    @GetMapping("/{id}")
	    public ResponseEntity<User> getUserById(@PathVariable Long id) {
	        Optional<User> user = userService.getUserById(id);
	        if (user.isPresent()) {
	            return new ResponseEntity<>(user.get(), HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	
	    
	    
	    @PostMapping
	    public ResponseEntity<User> createNewUser(@RequestBody User user){
	    	
	    	User userAvailable = userService.getUserByName(user.getFirstName());
	    	
	    	if(userAvailable!=null) {
	    		return new ResponseEntity(userAvailable,HttpStatus.FOUND);
	    	}
	    	
	    	User newUser = userService.createNewUser(user);
	    	return new ResponseEntity<> (newUser,HttpStatus.CREATED);
			
	    }
	    
	    @PutMapping("/{id}")
	    public ResponseEntity<User> updateUser(@PathVariable Long id,@RequestBody User user){
	    	System.out.println("Received user object: " + user);
	    	User existUser=userService.updateUserById(id,user);
	    	
	    	return new ResponseEntity<User>(existUser,HttpStatus.OK);
	    
	    }
	    
	    @DeleteMapping("/{id}")
	    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
	        Optional<User> isUser = userService.getUserById(id);
	        
	        try {
	            if (isUser.isEmpty()) {
	                return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
	            }

	            userService.deleteUser(id);
	            return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
	            
	        } catch (Exception e) {
	            return new ResponseEntity<>("Failed to delete user: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }

	    
	    
	    
}
