package ch.zhaw.mima.addresses;

import ch.zhaw.mima.validator.AddressValidatorException;
import ch.zhaw.mima.validator.ValidatorFactory;

public class PrinterAddress implements Address{
	
	
	private String printerIP;

	public PrinterAddress(String printerIP)
	{
		this.setPrinterIP(printerIP);
	}

	public String getPrinterIP() {
		return printerIP;
	}

	@Override
	public String toString() {
		return "PrinterAddress [printerIP=" + printerIP + "]";
	}

	public void setPrinterIP(String printerIP) {
		this.printerIP = printerIP;
	}

	@Override
	public void validate() throws AddressValidatorException {
		ValidatorFactory.createPrinterAddressValidator().validate(this);
		
	}

}
