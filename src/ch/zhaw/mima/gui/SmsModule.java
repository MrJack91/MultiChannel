/**
 * 
 */
package ch.zhaw.mima.gui;

import ch.zhaw.mima.App;
import ch.zhaw.mima.addresses.EmailAddress;
import ch.zhaw.mima.addresses.PhoneAddress;
import ch.zhaw.mima.message.EmailImpl;
import ch.zhaw.mima.message.SMS;
import ch.zhaw.mima.message.SMSImpl;
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
  protected void putMessageInQueue(SMS message) {
  	try {
	    getApp().getMessagingService().addMessage(message);
    } catch (AddressValidatorException e) {
    	System.out.println("ungültige Mobiletelefon Nummer");
    }
  }

	/* (non-Javadoc)
	 * @see ch.zhaw.mima.gui.AbstractMessagingModule#createMessage()
	 */
  @Override
  protected SMS createMessage() {
  	return new SMSImpl();
  }
	
}
