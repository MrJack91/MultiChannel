package ch.zhaw.mima.message;

import ch.zhaw.mima.addresses.Address;

/**
 * 
 */

/**
 * @author michael
 * 
 */
public interface Message<T extends Address> extends Sendable<T> {
	/**
	 * get the message text
	 * @return
	 */
	public String getText();

	/**
	 * set the message text
	 * @param text
	 */
	public void setText(String text);

}
