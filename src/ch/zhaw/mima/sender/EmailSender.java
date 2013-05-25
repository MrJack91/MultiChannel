package ch.zhaw.mima.sender;

import ch.zhaw.mima.message.Email;

public class EmailSender implements MessageSender<Email> {

	@Override
	public void send(Email message) {
		System.out.println("sending email "+message);
		
	}


}
