package br.com.geradorASN.entity.rest.v1.post.request;

public class Contact {

	private String EmailAddress;
	
	public Contact() {
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
