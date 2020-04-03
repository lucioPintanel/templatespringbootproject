package com.springboot.template.service;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.template.domain.User;
import com.springboot.template.repositories.UserRepository;

@Service
public class DBService {
	
	@Autowired
	private UserRepository userRepo;
	
	public void instantiateTestDatabase() throws ParseException {
		User user1 = new User(null, "Funalo Ciclano", "fulano@mail.com", "123");
		User user2 = new User(null, "Beltrano Ciclano", "beltrano@mail.com", "123");
		
		userRepo.saveAll(Arrays.asList(user1, user2));
	}
}
