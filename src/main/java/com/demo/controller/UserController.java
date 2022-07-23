package com.demo.controller;

import java.util.List;
import java.util.Optional;

import com.demo.entity.User;
import com.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@Autowired
	UserService userService;

	// add users data
	@PostMapping("/user")
	public User addUserdata(@RequestBody User user) {
		return userService.insertUser(user);

	}

	// get all user Data
	@GetMapping("/user")
	public ResponseEntity<?> getAllUsersData(
			@RequestParam(defaultValue = "") String search,
			@RequestParam(defaultValue = "1") String pageNumber,
			@RequestParam(defaultValue = "10") String pageSize) {
		System.out.println("hello");
		
		Page<User> user = userService.getAllUsers(search, pageNumber, pageSize);

		System.out.println("hello2");

	
		if(user.getTotalElements()!=0) {
			
				
			
			System.out.println("hello1");
			
			return new ResponseEntity<>(user.getContent(),HttpStatus.OK);
			
		}
		return new ResponseEntity<>("fail", HttpStatus.BAD_REQUEST);
	}

	// get user by id
	@GetMapping("/user/{id}")
	public Optional<User> getUserById(@RequestBody User user, @PathVariable Integer id) {

		return userService.getByUserId(user, id);

	}

	// update users
	@PutMapping("/user/{id}")
	public User updateUser(@RequestBody User user, @PathVariable Integer id) {
		user.setId(id);
		return userService.addUser(user);

	}

	// delete all users

	@DeleteMapping("/user")
	public void deleteAllUser(User user) {
		userService.deleteAllUser(user);

	}

	// delete user by id
	@DeleteMapping("/user/{id}")
	public void deleteUser(@PathVariable Integer id) {
		userService.deleteUser(id);
	}

}
