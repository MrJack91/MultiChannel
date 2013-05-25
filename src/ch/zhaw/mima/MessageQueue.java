package ch.zhaw.mima;

import ch.zhaw.mima.addresses.Address;
import ch.zhaw.mima.message.Sendable;

/**
 * 
 */

/**
 * @author michael
 *
 */
public interface MessageQueue<T extends Address> {
	
	public void processQueue();
	
	public void addSendable(Sendable<T> sendable);

	
}
