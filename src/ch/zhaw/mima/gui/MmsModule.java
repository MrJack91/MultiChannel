/**
 * 
 */
package ch.zhaw.mima.gui;

import ch.zhaw.mima.App;
import ch.zhaw.mima.addresses.PhoneAddress;
import ch.zhaw.mima.message.MMS;
import ch.zhaw.mima.message.MMSImpl;
import ch.zhaw.mima.message.reminder.MMSReminder;
import ch.zhaw.mima.message.reminder.Reminder;
import ch.zhaw.mima.validator.AddressValidatorException;

/**
 * @author michael
 * 
 */
public class MmsModule extends AbstractMessagingModule<MMS> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1303619438427721818L;

	/**
	 * construct
	 */
	public MmsModule(App app) {
		super(app);
		this.frameTitle = "MMS versenden";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.zhaw.mima.gui.AbstractMessagingModule#addAddressesToMessage(java.lang
	 * .String, ch.zhaw.mima.message.Message)
	 */
	@Override
	protected void addAddressesToMessage(String addressString, MMS message) {
		String[] addresses = addressString.split(",");
		for (String oneAddress : addresses)
			message.addAddress(new PhoneAddress(oneAddress));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.zhaw.mima.gui.AbstractMessagingModule#putMessageInQueue(ch.zhaw.mima
	 * .message.Message)
	 */
	@Override
	protected void putMessageInQueue(MMS message)
			throws AddressValidatorException {

		getApp().getMessagingService().addMessage(message);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.zhaw.mima.gui.AbstractMessagingModule#createMessage()
	 */
	@Override
	protected MMS createMessage() {
		return new MMSImpl();
	}

	@Override
	protected Reminder<MMS> createReminderMessage() {
		return new MMSReminder();
	}

}
