package com.home.email.service;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.home.email.model.EmailDetails;

@Service
public class EmailServiceImpl implements EmailService{
	
    @Autowired
    private JavaMailSender sender;
	
	Session session;
	public MimeMessage message(EmailDetails emailDetails) {
		//MimeMessage message = new MimeMessage(session);
                MimeMessage message = sender.createMimeMessage();
		
		try {
                
		InternetAddress[] address = new InternetAddress[emailDetails.getMyTo().length];
		
		//Add multiple recipients to InternetAddress array
		//TODO Parse through multiple email recipients
		for(int i =0;  i <  emailDetails.getMyTo().length; i++) {
			address[i] = new InternetAddress(emailDetails.getMyTo()[i]);
		}
		for(int k = 0; k < address.length; k++) {
			message.addRecipient(RecipientType.TO, address[k]);
		}
		
			//TODO add set for an email attachment
            //Set the email sender
            message.setFrom(new InternetAddress(emailDetails.getMyFrom()));
            //Set the email subject
	        message.setSubject(emailDetails.getMySubjectTemplate());   
            //Message without attachment
	        message.setText(emailDetails.getMyBodyTemplate());   
              
		}catch (MessagingException m) {
			
		}
		
		return message;
	}
    
        
    public void send(EmailDetails emailDetails){
           
        sender.send(message(emailDetails));
           

    }
    

}
