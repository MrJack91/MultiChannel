package ch.zhaw.mima.sender;

import ch.zhaw.mima.message.MMS;

public class MMSSender implements MessageSender<MMS> {

	@Override
	public void send(MMS message) {
		System.out.println("sending MMS "+message);
		
	}

}
