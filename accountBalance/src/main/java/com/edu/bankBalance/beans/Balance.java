package com.edu.bankBalance.beans;

public class Balance {

	int id;
	double amount;
	
	public Balance(int id) {
		this.id=id;
		this.amount=100;
	}
	
	public Balance(int id, double amount) {
		this.id=id;
		this.amount=amount;
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

	public double widthdraw(double wdm) {
		this.amount = this.amount-wdm;
		return this.amount;
	}
	
	public double deposite(double dpm) {
		this.amount = this.amount+dpm;
		return this.amount;
	}
}
