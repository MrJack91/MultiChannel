package ch.zhaw.mima.sender;

import ch.zhaw.mima.message.SMS;

public class SMSSender implements MessageSender<SMS> {

	@Override
	public void send(SMS message) {
		System.out.println("sending sms "+message);
		
	}

}
