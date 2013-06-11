/**
 * 
 */
package ch.zhaw.mima.gui;

import ch.zhaw.mima.App;
import ch.zhaw.mima.addresses.PhoneAddress;
import ch.zhaw.mima.message.SMS;
import ch.zhaw.mima.message.SMSImpl;
import ch.zhaw.mima.message.reminder.Reminder;
import ch.zhaw.mima.message.reminder.SMSReminder;
import ch.zhaw.mima.validator.AddressValidatorException;


/**
 * @author michael
 *
 */
public class SmsModule extends AbstractMessagingModule<SMS> {

	/**
	 * 
	 */
  private static final long serialVersionUID = -5642229309912805372L;

	/**
	 * construct
	 */
	public SmsModule(App app) {
		super(app);
		this.frameTitle = "SMS versenden";
	}

	/* (non-Javadoc)
	 * @see ch.zhaw.mima.gui.AbstractMessagingModule#addAddressesToMessage(java.lang.String, ch.zhaw.mima.message.Message)
	 */
  @Override
  protected void addAddressesToMessage(String addressString, SMS message) {
  	String[] addresses = addressString.split(",");
  	for(String oneAddress: addresses)
    	message.addAddress(new PhoneAddress(oneAddress));
  }

	/* (non-Javadoc)
	 * @see ch.zhaw.mima.gui.AbstractMessagingModule#putMessageInQueue(ch.zhaw.mima.message.Message)
	 */
  @Override
  protected void putMessageInQueue(SMS message) throws AddressValidatorException  {
  	
	    getApp().getMessagingService().addMessage(message);

  }

	/* (non-Javadoc)
	 * @see ch.zhaw.mima.gui.AbstractMessagingModule#createMessage()
	 */
  @Override
  protected SMS createMessage() {
  	return new SMSImpl();
  }


@Override
protected Reminder<SMS> createReminderMessage() {
	
	return new SMSReminder();
}

	
}
