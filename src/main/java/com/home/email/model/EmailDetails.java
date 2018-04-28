/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.home.email.model;

/**
 *
 * @author codeRbbt
 */
public class EmailDetails {
	
	private String mySubjectTemplate;
	private String myBodyTemplate;
	private String myTo[];
	private String myFrom;
    private String [] attachments;

    //Construct
    public EmailDetails(){
        
    }
    
	public String getMyFrom() {
		return myFrom;
	}

	public void setMyFrom(String myFrom) {
		this.myFrom = myFrom;
	}

	public String getMySubjectTemplate() {
		return mySubjectTemplate;
	}

	public void setMySubjectTemplate(String mySubjectTemplate) {
		this.mySubjectTemplate = mySubjectTemplate;
	}

	public String getMyBodyTemplate() {
		return myBodyTemplate;
	}

	public void setMyBodyTemplate(String myBodyTemplate) {
		this.myBodyTemplate = myBodyTemplate;
	}
	
	public String[] getMyTo() {
		return myTo;
	}

	public void setMyTo(String[] myTo) {
		this.myTo = myTo;
	}
       
        
        public String[] getAttachments() {
            return attachments;
        }

        public void setAttachments(String[] attachments) {
            this.attachments = attachments;
    }
    
}
