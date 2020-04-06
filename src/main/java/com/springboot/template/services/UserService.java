package com.springboot.template.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.template.domain.User;
import com.springboot.template.dto.UserDTO;
import com.springboot.template.dto.UserNewDTO;
import com.springboot.template.repositories.UserRepository;
import com.springboot.template.services.exceptions.DataIntegrityException;
import com.springboot.template.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;

	public User find(Integer id) {
		Optional<User> obj = userRepo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + User.class.getName()));
	}

	public User findByEmail(String email) {
		User obj = userRepo.findByEmail(email);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + ", Tipo: " + User.class.getName());
		}
		return obj;
	}

	public List<User> findAll() {
		return userRepo.findAll();
	}

	@Transactional
	public User insert(User obj) {
		obj.setId(null);
		obj = userRepo.save(obj);
		return obj;
	}

	private void updateData(User newObj, User obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
	}

	public User update(User obj) {
		User newObj = this.find(obj.getId());
		this.updateData(newObj, obj);
		return userRepo.save(newObj);
	}

	public void delete(Integer id) {
		try {
			userRepo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir porque há pedidos relacionados");
		}
	}

	public User fromDTO(UserDTO obj) {
		return new User(obj.getId(), obj.getNome(), obj.getEmail(), null);
	}

	public User fromDTO(UserNewDTO obj) {
		User user = new User(null, obj.getNome(), obj.getEmail(), obj.getSenha());
		return user;
	}
}
