package com.cdac.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.backend.dto.UsersDTO;
import com.cdac.backend.services.UserService;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/")
	public String hello() {
		return "home";
	}
	@GetMapping("/{name}")
	public UsersDTO getByUsername(@PathVariable("name") String name) {
		System.out.println(name);
		return userService.getByUsername(name);
	}
	@PostMapping("/")
	public boolean saveUser(@RequestBody UsersDTO userDTO) {
		return userService.save(userDTO);
	}
}
