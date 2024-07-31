package com.jsp.boot_user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.boot_user.dao.User;

import com.jsp.boot_user.service.UsereService;
import com.jsp.boot_user.util.ResponseStructure;

@RestController
public class UserContoller {
	@Autowired
	UsereService service;

	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User u) {
		return service.SaveUser(u);
	}

	@GetMapping("/find")
	public ResponseEntity<ResponseStructure<User>> findById(@RequestParam int id) {
		return service.findById(id);
	}

	@GetMapping("/findEmail")
	public ResponseEntity<ResponseStructure<User>> findById(@RequestParam String email) {
		return service.findByEmail(email);
	}

	@DeleteMapping("/deleteid")
	public ResponseEntity<ResponseStructure<User>> delete(@RequestParam int id) {
		return service.delete(id);
	}

	@DeleteMapping("/deleteemail")
	public ResponseEntity<ResponseStructure<User>> delete(@RequestParam String email) {
		return service.delete(email);
	}
}
