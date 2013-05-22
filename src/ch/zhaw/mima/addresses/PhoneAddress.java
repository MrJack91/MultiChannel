package ch.zhaw.mima.addresses;

import ch.zhaw.mima.validator.AddressValidatorException;
import ch.zhaw.mima.validator.ValidatorFactory;


public class PhoneAddress implements Address{

	protected String number;

	public PhoneAddress(String number) {
	
		super();
		this.number = number;
	}

	public String getNumber() {
		return number;
	}

	@Override
	public String toString() {
		return "PhoneAddress [number=" + number + "]";
	}

	@Override
	public void validate() throws AddressValidatorException {
		ValidatorFactory.createPhoneValidator().validate(this);
		
	}

	

}