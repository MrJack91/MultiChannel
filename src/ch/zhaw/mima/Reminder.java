package ch.zhaw.mima;
import ch.zhaw.mima.addresses.Address;
import ch.zhaw.mima.message.Message;

/**
 * 
 */

/**
 * @author michael
 *
 */
public interface Reminder<T extends Address> extends Message<T> {
	
	public Message<T> getOriginalMessage();
	
	
}
