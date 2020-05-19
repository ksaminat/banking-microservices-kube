package com.edu.bankAccount.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.edu.bankAccount.model.Balance;
import com.edu.bankAccount.model.User;

@Service
public class BankingAccountService {

	@Autowired
	RestTemplate rt;
	List<User> userStore = null;
	
	static String uri = null;
	
	public BankingAccountService() {
		userStore = new ArrayList();
		User user = new User(1, "default-user");
		user.setBalance(new Balance(1, 1000));
		userStore.add(user);
	}
	
	public List<User> getUserDetails(){
		return userStore;
	}
	
	public User getUserDetail(int id) {
		
		String ip = System.getenv("USER_BALANCE_SERVICE_HOST");
		String port = System.getenv("USER_BALANCE_SERVICE_PORT");
		uri = "http://" + ip + ":" + port + "/balance/";
		
		Optional<User> user = userStore.parallelStream().filter((u) -> u.getId()==id)
			.findFirst();
		
		if(!user.isPresent())
			return null;
		
		User user_obj = user.get();
		Balance b = rt.getForObject(uri + user.get().getId(), Balance.class);
		user_obj.setBalance(b);
		
		return user_obj;
	}
	
	public void createUser(User user) {
		Balance b = new Balance(user.getBalance());
		try {
			RequestEntity<Balance> request = RequestEntity
				     .post(new URI(uri))
				     .accept(MediaType.APPLICATION_JSON)
				     .body(b);
			rt.exchange(request, Void.class);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
		userStore.add(user);
	}
	
	public void updateUser(User user) {
		userStore = userStore.stream().filter((u) -> u.getId()!=user.getId())
			.collect(Collectors.toList());
		userStore.add(user);
	}
	
	public User delete(int id) {
		Optional<User> user = userStore.stream().filter((u) -> u.getId()==id)
						.findFirst();
		
		if(!user.isPresent())
			return null;
		
		rt.delete(uri + user.get().getId());
		userStore.remove(user.get());
		return user.get();
	}
}
