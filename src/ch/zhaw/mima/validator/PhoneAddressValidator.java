package ch.zhaw.mima.validator;

import ch.zhaw.mima.addresses.PhoneAddress;

public class PhoneAddressValidator implements AddressValidator<PhoneAddress> {

	@Override
	public void validate(PhoneAddress address) throws AddressValidatorException {
		
		
		if(address.getNumber().isEmpty())
			throw new AddressValidatorException("Error in '"+address.getNumber()+"'\nphone address is empty");
		

	}

}
