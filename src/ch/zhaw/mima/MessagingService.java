package ch.zhaw.mima;

import ch.zhaw.mima.addresses.EmailAddress;
import ch.zhaw.mima.addresses.PhoneAddress;
import ch.zhaw.mima.addresses.PrinterAddress;
import ch.zhaw.mima.message.Email;
import ch.zhaw.mima.message.MMS;
import ch.zhaw.mima.message.PrinterJob;
import ch.zhaw.mima.message.SMS;
import ch.zhaw.mima.queue.MessageQueue;
import ch.zhaw.mima.queue.MessageQueueImpl;
import ch.zhaw.mima.queue.Tickable;
import ch.zhaw.mima.sender.EmailSender;
import ch.zhaw.mima.sender.MMSSender;
import ch.zhaw.mima.sender.PrinterJobSender;
import ch.zhaw.mima.sender.SMSSender;
import ch.zhaw.mima.validator.AddressValidatorException;
import ch.zhaw.mima.validator.ValidatorService;

public class MessagingService implements Tickable {

	private ValidatorService validatorService;
	private MessageQueue<PrinterJob> printerQueue;

	private MessageQueueImpl<MMS> mmsQueue;

	private MessageQueueImpl<SMS> smsQueue;
	private MessageQueueImpl<Email> emailQueue;
	private EmailSender emailSender;
	private SMSSender smsSender;
	private MMSSender mmsSender;
	private PrinterJobSender printerJobSender;

	public MessagingService() {
		validatorService = new ValidatorService();

		emailSender = new EmailSender();
		smsSender = new SMSSender();
		mmsSender = new MMSSender();
		printerJobSender = new PrinterJobSender();

		printerQueue = new MessageQueueImpl<PrinterJob>();
		mmsQueue = new MessageQueueImpl<MMS>();
		smsQueue = new MessageQueueImpl<SMS>();
		emailQueue = new MessageQueueImpl<Email>();
	}

	public void addMessage(Email message) throws AddressValidatorException {

		for (EmailAddress address : message.getAdresses())
			validatorService.validate(address);
		emailQueue.addSendable(message);
	}

	public void addMessage(SMS message) throws AddressValidatorException {
		for (PhoneAddress address : message.getAdresses())
			validatorService.validate(address);
		smsQueue.addSendable(message);
	}

	public void addMessage(MMS message) throws AddressValidatorException {
		for (PhoneAddress address : message.getAdresses())
			validatorService.validate(address);
		mmsQueue.addSendable(message);
	}

	public void addMessage(PrinterJob message) throws AddressValidatorException {
		for (PrinterAddress address : message.getAdresses())
			validatorService.validate(address);
		printerQueue.addSendable(message);
	}

	@Override
	public void onTick() {
		emailQueue.processQueue(emailSender);
		mmsQueue.processQueue(mmsSender);
		smsQueue.processQueue(smsSender);
		printerQueue.processQueue(printerJobSender);

	}

}
