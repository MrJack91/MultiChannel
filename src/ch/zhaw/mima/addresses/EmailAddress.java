package ch.zhaw.mima.addresses;



public class EmailAddress implements Address {
	
	
	/**
   * @uml.property  name="email"
   */
	private String email;

	public EmailAddress(String email) {
		this.email = email;
	}
	
	/**
   * @return
   * @uml.property  name="email"
   */
	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "EmailAddress [email=" + email + "]";
	}

	


	

	

	
}
