package com.edu.bankBalance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.bankBalance.beans.Balance;
import com.edu.bankBalance.service.BalanceService;

@RestController
public class BalanceController {

	@Autowired
	BalanceService bs = null;
	
	@RequestMapping("/")
	public String default_method() {
		return "Welcome to Banking Balance Controller";
	}
	
	@RequestMapping("/balance")
	public String balancePath() {
		return "Welcome to Balance";
	}
	
	@GetMapping("/balances")
	public List<Balance> getBalances() {
		return bs.getBalances();
	}
	
	@GetMapping("/balance/{id}")
	public Balance getBalance(@PathVariable("id") int id) {
		return bs.getBalance(id);
	}
	
	@PostMapping("/balance")
	public void createBalance(@RequestBody Balance balance) {
		bs.createBalance(balance);
	}
	
	@PostMapping("/widthdraw")
	public void widthdraw(@RequestBody Balance balance) {
		bs.widthdraw(balance);
	}
	
	@PostMapping("/deposite")
	public void deposite(@RequestBody Balance balance) {
		bs.deposite(balance);
	}
	
	@DeleteMapping("/balance/{id}")
	public void delete(@PathVariable("id") int id) {
		bs.delete(id);
	}
}
