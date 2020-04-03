package com.springboot.template.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springboot.template.domain.User;
import com.springboot.template.dto.UserDTO;
import com.springboot.template.dto.UserNewDTO;
import com.springboot.template.service.UserService;

@RestController
@RequestMapping(path = "/user")
public class UserController {
	
	private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<User> find(@PathVariable Integer id) {
		User obj = this.userService.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value="/email", method=RequestMethod.GET)
	public ResponseEntity<User> find(@RequestParam(value="value") String email) {
		LOG.info(email);
		User obj = this.userService.findByEmail(email);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody UserNewDTO objDto) {
		User obj = this.userService.fromDTO(objDto);
		obj = this.userService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody UserDTO objDto, @PathVariable Integer id) {
		User obj = this.userService.fromDTO(objDto);
		obj.setId(id);
		obj = this.userService.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		this.userService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> list = this.userService.findAll();
		List<UserDTO> listDTO = list.stream().map(obj -> new UserDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
}
