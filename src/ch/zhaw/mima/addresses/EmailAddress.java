package ch.zhaw.mima.addresses;

import ch.zhaw.mima.validator.AddressValidatorException;
import ch.zhaw.mima.validator.ValidatorFactory;


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

	@Override
	public void validate() throws AddressValidatorException {
		ValidatorFactory.createEmailAddressValidator().validate(this);
	}


	

	

	
}
