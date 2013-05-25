package ch.zhaw.mima.addresses;



public class EmailAddress implements Address {
	
	
	private String email;

	public EmailAddress(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "EmailAddress [email=" + email + "]";
	}

	


	

	

	
}
