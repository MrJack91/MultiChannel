package ch.zhaw.mima.validator;

import ch.zhaw.mima.addresses.EmailAddress;
import ch.zhaw.mima.addresses.PhoneAddress;
import ch.zhaw.mima.addresses.PrinterAddress;

public class ValidatorService {

	/**
   * @uml.property  name="emailValidator"
   * @uml.associationEnd  
   */
	private EmailAddressValidator emailValidator;
	/**
   * @uml.property  name="printerValidator"
   * @uml.associationEnd  
   */
	private PrinterAddressValidator printerValidator;
	/**
   * @uml.property  name="phoneValidator"
   * @uml.associationEnd  
   */
	private PhoneAddressValidator phoneValidator;


	
	public void validate(EmailAddress address) throws AddressValidatorException {
		EmailAddressValidator validator = getValidatorForAddressType(address);
		validator.validate(address);
	}

	public void validate(PhoneAddress address) throws AddressValidatorException {
		PhoneAddressValidator validator = getValidatorForAddressType(address);
		validator.validate(address);
	}

	public void validate(PrinterAddress address)
			throws AddressValidatorException {
		PrinterAddressValidator validator = getValidatorForAddressType(address);
		validator.validate(address);
	}

	public PhoneAddressValidator getValidatorForAddressType(PhoneAddress address) {
		if (phoneValidator == null) {
			phoneValidator = ValidatorFactory.createPhoneValidator();
		}
		return phoneValidator;
	}

	public PrinterAddressValidator getValidatorForAddressType(
			PrinterAddress address) {
		if (printerValidator == null) {
			printerValidator = ValidatorFactory.createPrinterAddressValidator();
		}
		return printerValidator;
	}

	public EmailAddressValidator getValidatorForAddressType(EmailAddress address) {
		if (emailValidator == null) {
			emailValidator = ValidatorFactory.createEmailAddressValidator();
		}
		return emailValidator;

	}

}