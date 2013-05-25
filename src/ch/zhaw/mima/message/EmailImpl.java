package ch.zhaw.mima.message;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

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
