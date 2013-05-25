package ch.zhaw.mima.sender;

import ch.zhaw.mima.addresses.Address;
import ch.zhaw.mima.message.Sendable;

public interface MessageSender<T extends Sendable<? extends Address>> {
	
	public void send(T message);

	

}
