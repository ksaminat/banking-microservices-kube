package com.edu.bankAccount.model;

public class Balance {

	int id;
	double amount;
	
	public Balance(int id, double amount) {
		this.id = id;
		this.amount = amount;
	}

	public Balance(Balance b) {
		this.id = b.id;
		this.amount = b.amount;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}
