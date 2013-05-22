package ch.zhaw.mima.validator;


public class ValidatorFactory {
	
	
	public static MMSAddressValidator createMMSAddressValidator()
	{
		return new MMSAddressValidator();
	}
	
	public static SMSAddressValidator createSmsAddressValidator()
	{
		return new SMSAddressValidator();
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
