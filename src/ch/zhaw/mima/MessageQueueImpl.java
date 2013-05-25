package ch.zhaw.mima;

import java.util.ArrayDeque;
import java.util.Date;

import ch.zhaw.mima.addresses.Address;
import ch.zhaw.mima.message.Sendable;

public class MessageQueueImpl<T extends Address> implements MessageQueue<T> {

	private ArrayDeque<Sendable<T>> sendables;

	public MessageQueueImpl() {
		sendables = new ArrayDeque<Sendable<T>>();
	}

	@Override
	public synchronized void processQueue() {

		for (Sendable<? extends Address> oneSendable : sendables) {
			if (oneSendable.getSendTime() <= getNow()) {
				oneSendable.send();
				sendables.remove(oneSendable);
			}
		}

	}

	private long getNow() {
		return new Date().getTime();
	}

	@Override
	public synchronized void addSendable(Sendable<T> sendable) {
		sendables.add(sendable);

	}

}
