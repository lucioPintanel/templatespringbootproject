package com.springboot.template.services;

import org.springframework.security.core.context.SecurityContextHolder;

import com.springboot.template.security.UserSS;

public class UserServiceSecurity {
	public static UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} catch (Exception e) {
			return null;
		}
	}
}
