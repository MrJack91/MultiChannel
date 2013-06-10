/**
 * 
 */
package ch.zhaw.mima.gui;

import ch.zhaw.mima.App;
import ch.zhaw.mima.addresses.PrinterAddress;
import ch.zhaw.mima.message.PrinterJob;
import ch.zhaw.mima.message.PrinterJobImpl;
import ch.zhaw.mima.validator.AddressValidatorException;


/**
 * @author michael
 *
 */
public class PrintModule extends AbstractMessagingModule<PrinterJob> {

	/**
	 * 
	 */
  private static final long serialVersionUID = 1264836454684372190L;

	/**
	 * construct
	 */
	public PrintModule(App app) {
		super(app);
		this.frameTitle = "Text ausdrucken";
	}

	/* (non-Javadoc)
	 * @see ch.zhaw.mima.gui.AbstractMessagingModule#addAddressesToMessage(java.lang.String, ch.zhaw.mima.message.Message)
	 */
  @Override
  protected void addAddressesToMessage(String addressString, PrinterJob message) {
  	String[] addresses = addressString.split(",");
  	for(String oneAddress: addresses)
    	message.addAddress(new PrinterAddress(oneAddress));
  }

	/* (non-Javadoc)
	 * @see ch.zhaw.mima.gui.AbstractMessagingModule#putMessageInQueue(ch.zhaw.mima.message.Message)
	 */
  @Override
  protected void putMessageInQueue(PrinterJob message) {
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
  protected PrinterJob createMessage() {
	  return new PrinterJobImpl();
  }

	
}
