package com.rash.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rash.model.User;
import com.rash.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/allUsers")
	public ResponseEntity<List<User>> getAll() {
		return userService.getAllUsers();
	}

	@PostMapping("/add")
	public ResponseEntity<String> add(@RequestBody User user) {
		return userService.addUser(user);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		userService.deleteUser(id);
	}

	@PutMapping("/update/{id}")
	private User update(@RequestBody User user, @PathVariable Long id) {
		userService.updateUser(user, id);
		return user;
	}
}
