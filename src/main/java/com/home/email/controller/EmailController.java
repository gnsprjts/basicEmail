/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.home.email.controller;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.home.email.model.EmailDetails;
import com.home.email.service.EmailService;

/**
 *
 * @author codeRbbt
 */
@RestController
public class EmailController {
    
    @Autowired
    private EmailService emailService;
    
    @Value("${spring.mail.username}")
    private String senderEmail; 
    
    private Logger emlSndLog; 
   
    
    @RequestMapping("/sendEml")
    public String signupSuccess(@RequestBody EmailDetails emailDetails) {
 
        //set the email sender
        emailDetails.setMyFrom(senderEmail);
       
        //Call interface to send email
        try{
            emailService.send(emailDetails);
        }catch(MailException m){
        	emlSndLog.error("Email Send Error");
        }
        
        return "Email Send has been success";

    }

}
