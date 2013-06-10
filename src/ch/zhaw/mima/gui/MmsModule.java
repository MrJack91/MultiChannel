/**
 * 
 */
package ch.zhaw.mima.gui;

import ch.zhaw.mima.App;
import ch.zhaw.mima.addresses.PhoneAddress;
import ch.zhaw.mima.message.MMS;
import ch.zhaw.mima.message.MMSImpl;
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

	/* (non-Javadoc)
	 * @see ch.zhaw.mima.gui.AbstractMessagingModule#addAddressesToMessage(java.lang.String, ch.zhaw.mima.message.Message)
	 */
  @Override
  protected void addAddressesToMessage(String addressString, MMS message) {
  	String[] addresses = addressString.split(",");
  	for(String oneAddress: addresses)
    	message.addAddress(new PhoneAddress(oneAddress));
  }

	/* (non-Javadoc)
	 * @see ch.zhaw.mima.gui.AbstractMessagingModule#putMessageInQueue(ch.zhaw.mima.message.Message)
	 */
  @Override
  protected void putMessageInQueue(MMS message) {
  	try {
	    getApp().getMessagingService().addMessage(message);
	    lbRecipient.setText("Empfänger");
    } catch (AddressValidatorException e) {
    	lbRecipient.setText("Empfänger - " + e.getMessage());
    }
	  
  }

	/* (non-Javadoc)
	 * @see ch.zhaw.mima.gui.AbstractMessagingModule#createMessage()
	 */
  @Override
  protected MMS createMessage() {
	  return new MMSImpl();
  }
	
}
