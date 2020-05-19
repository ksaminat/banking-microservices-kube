package com.edu.bankAccount.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.bankAccount.model.User;
import com.edu.bankAccount.service.BankingAccountService;

@RestController
public class BankingAccountController {

	@Autowired
	BankingAccountService bs = null;
	
	@RequestMapping("/")
	public String default_method() {
		return "Welcome to Banking Account Controller";
	}
	
	@GetMapping("/users")
	public List<User> getUserDetails(){
		return bs.getUserDetails();
	}
	
	@GetMapping("/user/{id}")
	public User getUserDetail(@PathVariable("id") int id) {
		return bs.getUserDetail(id);
	}
	
	@PostMapping("/user")	
	public void createUser(@RequestBody User user) {
		bs.createUser(user);
	}
	
	@PutMapping("/user")
	public void updateUser(@RequestBody User user) {
		bs.updateUser(user);
	}
	
	@DeleteMapping("/user/{id}")
	public User deleteUser(@PathVariable("id") int id) {
		return bs.delete(id);
	}
}
