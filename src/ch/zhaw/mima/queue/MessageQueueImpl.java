package ch.zhaw.mima.queue;

import java.util.ArrayDeque;
import java.util.Date;

import ch.zhaw.mima.addresses.Address;
import ch.zhaw.mima.message.Sendable;
import ch.zhaw.mima.sender.MessageSender;

public class MessageQueueImpl<T extends Sendable<? extends Address>> implements
		MessageQueue<T> {

	private ArrayDeque<T> sendables;

	public MessageQueueImpl() {
		sendables = new ArrayDeque<T>();

	}

	@Override
	public synchronized void processQueue(MessageSender<T> sender) {

		for (T oneSendable : sendables) {
			if (oneSendable.getSendTime() <= getNow()) {
				sender.send(oneSendable);
				sendables.remove(oneSendable);
			}
		}

	}

	private long getNow() {
		return new Date().getTime();
	}

	@Override
	public synchronized void addSendable(T sendable) {
		System.out.println("adding "+sendable+" to sendQueue");
		sendables.add(sendable);

	}

}
