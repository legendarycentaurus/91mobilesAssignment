package com.nanda.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
@Service
public class MailApi {
	/*@Autowired
	private MailSender crunchifymail;
	public void crunchifyReadyToSendEmail(String toAddress, String fromAddress, String subject, String msgBody) {
		 
		SimpleMailMessage crunchifyMsg = new SimpleMailMessage();
		crunchifyMsg.setFrom(fromAddress);
		crunchifyMsg.setTo(toAddress);
		crunchifyMsg.setSubject(subject);
		crunchifyMsg.setText(msgBody);
		crunchifymail.send(crunchifyMsg);
	}*/
}
