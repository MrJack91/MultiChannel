/**
 * 
 */
package ch.zhaw.mima.gui;

import ch.zhaw.mima.App;
import ch.zhaw.mima.addresses.EmailAddress;
import ch.zhaw.mima.message.Email;
import ch.zhaw.mima.message.EmailImpl;
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
	
	public void send() {
		
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
  protected void putMessageInQueue(Email message) {
  	try {
	    getApp().getMessagingService().addMessage(message);
	    // close window if send is success
	    lbRecipient.setText("Empfänger");
	    // mainFrame.show(false);
    } catch (AddressValidatorException e) {
    	lbRecipient.setText("Empfänger - " + e.getMessage());
    }
	  
  }

	/* (non-Javadoc)
	 * @see ch.zhaw.mima.gui.AbstractMessagingModule#addAddresses(ch.zhaw.mima.message.Message)
	 */
  @Override
  protected void addAddressesToMessage(String addressString, Email message) {
  	String[] addresses = addressString.split(",");
  	for(String oneAddress: addresses) {
  		System.out.println(oneAddress);
  		message.addAddress(new EmailAddress(oneAddress));
  	}
    	
  }
	
}
