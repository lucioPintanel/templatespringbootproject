package com.springboot.template.services;

import org.springframework.mail.SimpleMailMessage;

import com.springboot.template.domain.User;

public interface EmailService {
	
	void sendEmail(SimpleMailMessage msg);
	
	void sendNewPasswordEmail(User user, String newPass);
}
