/**
 * 
 */
package ch.zhaw.mima.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.internet.AddressException;

import ch.zhaw.mima.addresses.PrinterAddress;

/**
 * @author michael
 *
 */
public class PrinterAddressValidator implements AddressValidator<PrinterAddress> {


	private static final String PATTERN = 
			"^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
					"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
					"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
					"([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";



	/* (non-Javadoc)
	 * @see ch.zhaw.mima.validator.AddressValidator#validate(ch.zhaw.mima.validator.Address)
	 */
	@Override
	public void validate(PrinterAddress address) throws ValidationException {

		checkIfValidAddress(address);
		checkIfReachable(address);
		checkIfPrinter(address);


	}

	private void checkIfValidAddress(PrinterAddress address)  throws ValidationException{
		Pattern pattern = Pattern.compile(PATTERN);
		Matcher matcher = pattern.matcher(address.getPrinterIP());
		if(!matcher.matches())
			throw new ValidationException("invalid ip: "+address.getPrinterIP());
	}

	private void checkIfReachable(PrinterAddress address)  throws ValidationException{
		// TODO: ping ip address

	}

	private void checkIfPrinter(PrinterAddress address)  throws ValidationException{
		// TODO: check if there is a printer behind this ip address

	}

}
