package com.springrest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.Response;
import com.springrest.model.User;
import com.springrest.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService us;

	@GetMapping("/test")
	public String test() {
		return "this is test url";
	}

	@GetMapping("/getAllUser")
	public ResponseEntity<Response> getAllUser() {
		List<User> user = us.getAllUser();
		return ResponseEntity.status(200).body(new Response(true, "All users", user));
	}

	@PostMapping("/saveUser")
	public ResponseEntity<Map<String, Object>> saveUser(@RequestBody User user) {
		Map<String, Object> response = new HashMap<>();
		response.put("success", true);
		response.put("newUser", user);

		us.saveUser(user);

		return ResponseEntity.status(201).body(response);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Response> getUserById(@PathVariable("id") Integer id) {
		User u = us.getUserById(id);
		if (u == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response(false, "User not found", u));
		}
		return ResponseEntity.status(HttpStatus.OK).body(new Response(true, "user found", u));
	}

	@PutMapping("/updateUser/{id}")
	public ResponseEntity<Response> updateUser(@PathVariable("id") Integer id, @RequestBody User user) {
		User u = us.updateUser(id, user);
		if (u == null) {
			return ResponseEntity.status(404).body(new Response(false, "user not found", u));
		}
		return ResponseEntity.status(200).body(new Response(true, "user Updated", u));

	}

	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<Response> deleteUser(@PathVariable("id") Integer id) {
		User u = us.deleteUser(id);
		if (u == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response(false, "user not found", u));
		}
		return ResponseEntity.status(HttpStatus.OK).body(new Response(true, "user deleted", u));
	}

}
