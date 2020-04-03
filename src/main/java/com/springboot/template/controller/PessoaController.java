package com.springboot.template.controller;

import com.springboot.template.entity.Pessoa;
import com.springboot.template.repository.PessoaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/pessoas")
public class PessoaController {

	@Autowired
	private PessoaRepository repository;

	@GetMapping
	public Iterable<Pessoa> list() {
		return repository.findAll();
	}

}