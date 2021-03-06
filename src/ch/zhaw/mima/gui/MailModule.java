/**
 * 
 */
package ch.zhaw.mima.gui;

import ch.zhaw.mima.App;
import ch.zhaw.mima.addresses.EmailAddress;
import ch.zhaw.mima.message.Email;
import ch.zhaw.mima.message.EmailImpl;
import ch.zhaw.mima.message.reminder.EmailReminder;
import ch.zhaw.mima.message.reminder.Reminder;
import ch.zhaw.mima.validator.AddressValidatorException;


/**
 * @author michael
 *
 */
public class MailModule extends AbstractMessagingModule<Email> {

	/**
	 * 
	 */
  private static final long serialVersionUID = -219604484468188628L;

	/**
	 * construct
	 */
	public MailModule(App app) {
		super(app);
		this.frameTitle = "Mail versenden";
	}
	
	

	/* (non-Javadoc)
	 * @see ch.zhaw.mima.gui.AbstractMessagingModule#createMessage()
	 */
  @Override
  protected Email createMessage() {
	  return new EmailImpl();
  }

	/* (non-Javadoc)
	 * @see ch.zhaw.mima.gui.AbstractMessagingModule#putMessageInQueue(ch.zhaw.mima.message.Message)
	 */
  @Override
  protected void putMessageInQueue(Email message) throws AddressValidatorException {
 
	    getApp().getMessagingService().addMessage(message);

	  
  }

	/* (non-Javadoc)
	 * @see ch.zhaw.mima.gui.AbstractMessagingModule#addAddresses(ch.zhaw.mima.message.Message)
	 */
  @Override
  protected void addAddressesToMessage(String addressString, Email message) throws AddressValidatorException {
  	String[] addresses = addressString.split(",");
  	for(String oneAddress: addresses) {
  		
  		EmailAddress address = new EmailAddress(oneAddress.trim());
  		getApp().getMessagingService().getValidatorService().validate(address);
		message.addAddress(address);
  	}
    	
  }

@Override
protected Reminder<Email> createReminderMessage() {
	return new EmailReminder();
}
	
}
