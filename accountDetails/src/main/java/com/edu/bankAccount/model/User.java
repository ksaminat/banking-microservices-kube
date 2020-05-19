package com.edu.bankAccount.model;

public class User {
	
	int id;
	String name;
	Balance balance;

	public User(int id, String name) {
		this.id = id;
		this.name = name;
		this.balance = new Balance(id, 1000);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Balance getBalance() {
		return balance;
	}

	public void setBalance(Balance balance) {
		this.balance = balance;
	}
}
