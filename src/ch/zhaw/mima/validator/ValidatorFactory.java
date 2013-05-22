package ch.zhaw.mima.validator;



public class ValidatorFactory {
	
	
	public static PhoneAddressValidator createPhoneValidator()
	{
		return new PhoneAddressValidator();
	}
	

	
	public static PrinterAddressValidator createPrinterAddressValidator()
	{
		return new PrinterAddressValidator();
	}
	
	public static EmailAddressValidator createEmailAddressValidator()
	{
		return new EmailAddressValidator();
	}

}
