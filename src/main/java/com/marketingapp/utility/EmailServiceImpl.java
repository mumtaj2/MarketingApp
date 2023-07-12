package com.marketingapp.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender mailSender;
	
	@Override
	public void sendEmail(String to, String sub, String msg) {
		
		SimpleMailMessage massage =new SimpleMailMessage();
			massage.setTo(to);
			massage.setSubject(sub);
			massage.setText(msg);
			
			mailSender.send(massage);

	}

}
