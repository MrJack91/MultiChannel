package ch.zhaw.mima;

import java.util.Date;
import java.util.List;

import ch.zhaw.mima.addresses.Address;
import ch.zhaw.mima.message.Sendable;

public class MessageQueueImpl<T extends Address> implements MessageQueue<T> {

	private List<Sendable<T>> sendables;

	@Override
	public void processQueue() {

		for (Sendable<? extends Address> oneSendable : sendables) {
			if (oneSendable.getSendTime() <= getNow()) {
				oneSendable.send();
			}
		}

	}

	private long getNow() {
		return new Date().getTime();
	}

	@Override
	public void addSendable(Sendable<T> sendable) {
		sendables.add(sendable);
		
		
	}

	

}
