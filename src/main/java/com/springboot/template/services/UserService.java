package com.springboot.template.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.template.security.UserSS;
import com.springboot.template.domain.User;
import com.springboot.template.domain.enums.Perfil;
import com.springboot.template.dto.UserDTO;
import com.springboot.template.dto.UserNewDTO;
import com.springboot.template.repositories.UserRepository;
import com.springboot.template.services.exceptions.AuthorizationException;
import com.springboot.template.services.exceptions.DataIntegrityException;
import com.springboot.template.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private UserRepository userRepo;

	public User find(Integer id) {
		UserSS user = UserServiceSecurity.authenticated();
		if (user==null || !user.hasRole(Perfil.ADMIN) && !id.equals(user.getId())) {
			throw new AuthorizationException("Acesso negado");
		}
		
		Optional<User> obj = this.userRepo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + User.class.getName()));
	}

	public User findByEmail(String email) {
		UserSS user = UserServiceSecurity.authenticated();
		if (user==null || !user.hasRole(Perfil.ADMIN) && !email.equals(user.getUsername())) {
			throw new AuthorizationException("Acesso negado");
		}
		
		User obj = this.userRepo.findByEmail(email);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + ", Tipo: " + User.class.getName());
		}
		return obj;
	}

	public List<User> findAll() {
		return this.userRepo.findAll();
	}

	@Transactional
	public User insert(User obj) {
		obj.setId(null);
		obj = this.userRepo.save(obj);
		return obj;
	}

	private void updateData(User newObj, User obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
	}

	public User update(User obj) {
		User newObj = this.find(obj.getId());
		this.updateData(newObj, obj);
		return this.userRepo.save(newObj);
	}

	public void delete(Integer id) {
		this.find(id);
		try {
			this.userRepo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir porque há pedidos relacionados");
		}
	}

	public User fromDTO(UserDTO obj) {
		return new User(obj.getId(), obj.getNome(), obj.getEmail(), null);
	}

	public User fromDTO(UserNewDTO obj) {
		User user = new User(null, obj.getNome(), obj.getEmail(), pe.encode(obj.getSenha()));
		return user;
	}
}
