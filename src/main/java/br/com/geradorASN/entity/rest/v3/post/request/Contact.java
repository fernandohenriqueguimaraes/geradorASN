package br.com.geradorASN.entity.rest.v3.post.request;

import org.apache.commons.lang3.StringUtils;

public class Contact {

	private String EmailAddress;
	
	public Contact() {
		setEmailAddress(StringUtils.EMPTY);
	}

	public String getEmailAddress() {
		return EmailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		EmailAddress = emailAddress;
	}

	@Override
	public String toString() {
		return "Contact [EmailAddress=" + EmailAddress + "]";
	}
	
}
