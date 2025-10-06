package com.crud_app.com.crud_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud_app.com.crud_app.model.User;
import com.crud_app.com.crud_app.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	// Create User
	public User createUser(User newUser) {
		return userRepository.save(newUser);
	}

	// Update User
	public User updateUser(User newUser, Long id) {
		return userRepository.findById(id).map(user -> {
			user.setName(newUser.getName());
			user.setUsername(newUser.getUsername());
			user.setEmail(newUser.getEmail());
			return userRepository.save(user);
		}).orElseThrow();
	}

	// Delete User
	public void deleteUser(Long id) {
		if (!userRepository.existsById(id)) {
			throw new RuntimeException("User not found with ID: " + id);
		}
		userRepository.deleteById(id);
	}

	// Get user details
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	// Get User details by Id
	public Optional<User> getUserDetailsById(Long id) {
		return userRepository.findById(id);
	}

}
