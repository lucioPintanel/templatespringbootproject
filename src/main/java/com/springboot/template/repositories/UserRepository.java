package com.springboot.template.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.template.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	/*
	 * Define como transação não bloquente
	 */
	@Transactional(readOnly=true)
	User findByEmail(String email);
}
