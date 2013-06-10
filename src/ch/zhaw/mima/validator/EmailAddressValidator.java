package ch.zhaw.mima.validator;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import ch.zhaw.mima.addresses.EmailAddress;

/**
 * 
 */

/**
 * @author michael
 * 
 */
public class EmailAddressValidator implements AddressValidator<EmailAddress> {

	/**
	 * using the apache email library, as suggested here:
	 * http://stackoverflow.com/a/5931718/1463534
	 */
	@Override
	public void validate(EmailAddress address) throws AddressValidatorException {

		try {
			new InternetAddress(address.getEmail()).validate();
		} catch (AddressException e) {
			throw new AddressValidatorException("Error in "+address.getEmail()+":\n"+e.getMessage());
		}

	}

}
