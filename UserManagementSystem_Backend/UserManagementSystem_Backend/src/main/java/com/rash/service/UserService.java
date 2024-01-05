package com.rash.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rash.model.User;
import com.rash.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public ResponseEntity<List<User>> getAllUsers() {
		try {
			return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> addUser(User user) {
		userRepository.save(user);
		return new ResponseEntity<>("Success", HttpStatus.CREATED);
	}

	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

	public void updateUser(User user, Long id) {
		userRepository.save(user);
	}

}
