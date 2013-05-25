package ch.zhaw.mima;

import ch.zhaw.mima.addresses.EmailAddress;
import ch.zhaw.mima.addresses.PhoneAddress;
import ch.zhaw.mima.addresses.PrinterAddress;
import ch.zhaw.mima.message.Email;
import ch.zhaw.mima.message.MMS;
import ch.zhaw.mima.message.PrinterJob;
import ch.zhaw.mima.message.SMS;
import ch.zhaw.mima.validator.AddressValidatorException;
import ch.zhaw.mima.validator.ValidatorService;

public class MessagingService implements Tickable{

	private MessageQueue<EmailAddress> emailQueue;

	private MessageQueue<PhoneAddress> phoneQueue;

	private MessageQueue<PrinterAddress> printerQueue;

	private ValidatorService validatorService;

	public MessagingService() {
		validatorService = new ValidatorService();
		printerQueue = new MessageQueueImpl<PrinterAddress>();
		phoneQueue = new MessageQueueImpl<PhoneAddress>();
		emailQueue = new MessageQueueImpl<EmailAddress>();
	}

	public void addMessage(Email message) throws AddressValidatorException {

		for (EmailAddress address : message.getAdresses())
			validatorService.validate(address);
		emailQueue.addSendable(message);
	}

	public void addMessage(SMS message) throws AddressValidatorException {
		for (PhoneAddress address : message.getAdresses())
			validatorService.validate(address);
		phoneQueue.addSendable(message);
	}

	public void addMessage(MMS message) throws AddressValidatorException {
		for (PhoneAddress address : message.getAdresses())
			validatorService.validate(address);
		phoneQueue.addSendable(message);
	}

	public void addMessage(PrinterJob message) throws AddressValidatorException {
		for (PrinterAddress address : message.getAdresses())
			validatorService.validate(address);
		printerQueue.addSendable(message);
	}

	@Override
	public void onTick() {
		emailQueue.processQueue();
		phoneQueue.processQueue();
		printerQueue.processQueue();
		
	}

}
