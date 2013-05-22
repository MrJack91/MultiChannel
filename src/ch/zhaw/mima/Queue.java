package ch.zhaw.mima;
import ch.zhaw.mima.addresses.Address;
import ch.zhaw.mima.message.Sendable;
import ch.zhaw.mima.validator.AddressValidatorException;

/**
 * 
 */

/**
 * @author michael
 *
 */
public interface Queue {
	
	public void processQueue();
	
	public void addSendable(Sendable<? extends Address> sendable) throws AddressValidatorException;

}
