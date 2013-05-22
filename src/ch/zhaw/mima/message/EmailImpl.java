package ch.zhaw.mima.message;

import ch.zhaw.mima.addresses.EmailAddress;

/**
 * 
 */

/**
 * @author michael
 * 
 */
public class EmailImpl extends AbstractMessageImpl<EmailAddress> implements
		Email {

	@Override
	public void send() {
		System.out.println("sending Email " + this);
		
	}
	
	
	

	

	

}
