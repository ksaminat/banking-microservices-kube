package com.edu.bankBalance.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.edu.bankBalance.beans.Balance;

@Service
public class BalanceService {
	List<Balance> balances = null;
	
	public BalanceService() {
		Balance b = defaultBalance();
		balances = new ArrayList();
		balances.add(b);
	}
	
	public Balance defaultBalance() {
		Balance b = new Balance(1, 1000);
		return b;
	}
	
	public List<Balance> getBalances() {
		return balances;
	}
	
	public void createBalance(Balance balance) {
		Balance b = new Balance(balance.getId(), balance.getAmount());
		balances.add(b);
	}
	
	public Balance getBalance(int id) {
		Optional<Balance> b = balances.stream()
				.filter((balance) -> balance.getId()==id)
				.findFirst();
		
		if(b.isPresent())
			return b.get();
		
		return null;
	}
	
	public double deposite(Balance bal) {
		Optional<Double> b = balances.stream()
				.filter((balance) -> balance.getId()==bal.getId())
				.map((balance) -> balance.deposite(bal.getAmount()))
				.findFirst();
		
		if(b.isPresent())
			return b.get().doubleValue();
		
		return 0.0;
	}
	
	public double widthdraw(Balance bal) {
		Optional<Double> b = balances.stream()
				.filter((balance) -> balance.getId()==bal.getId())
				.map((balance) -> balance.widthdraw(bal.getAmount()))
				.findFirst();
		
		if(b.isPresent())
			return b.get().doubleValue();
		
		return 0.0;
	}
	
	public void delete(int id) {
		balances = balances.stream()
		.filter((balance) -> balance.getId()!=id)
		.collect(Collectors.toList());
	}
}
