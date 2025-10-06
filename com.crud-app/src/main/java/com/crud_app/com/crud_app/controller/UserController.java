package com.crud_app.com.crud_app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud_app.com.crud_app.model.User;
import com.crud_app.com.crud_app.service.UserService;

@RestController
@CrossOrigin(origins = ("https://fullstackappproject-ten.vercel.app/"))
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/adduser")
	public User creatUser(@RequestBody User newUser) {
		return userService.createUser(newUser);
	
	}
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	@GetMapping("/user/{id}")
	public Optional<User> getUserDetailsById(@PathVariable Long id){
		return userService.getUserDetailsById(id);
	}
	
	@PutMapping("/user/{id}")
	public User updateUser(@RequestBody User newUser,@PathVariable Long id) {
		return userService.updateUser(newUser, id);
		
	}

	@DeleteMapping("/user/{id}")
	public void deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
		
	}
}
