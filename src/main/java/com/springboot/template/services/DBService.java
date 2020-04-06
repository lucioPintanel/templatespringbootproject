package com.springboot.template.services;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.springboot.template.domain.User;
import com.springboot.template.domain.enums.Perfil;
import com.springboot.template.repositories.UserRepository;

@Service
public class DBService {
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private UserRepository userRepo;
	
	public void instantiateTestDatabase() throws ParseException {
		
		User user1 = new User(null, "Funalo Ciclano", "fulano@mail.com", pe.encode("123"));
		User user2 = new User(null, "Beltrano Ciclano", "beltrano@mail.com", pe.encode("123"));
		user2.addPerfil(Perfil.ADMIN);
		
		userRepo.saveAll(Arrays.asList(user1, user2));
	}
}
