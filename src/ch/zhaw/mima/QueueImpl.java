package ch.zhaw.mima;
import java.util.Date;
import java.util.List;

import ch.zhaw.mima.message.Message;


public class QueueImpl implements Queue {

	private List<Message> messages;

	@Override
	public void processQueue() {

		for (Message oneMessage : messages) {
			if (oneMessage.getSendTime() <= getNow()) {
				oneMessage.send();
			}
		}

	}

	private long getNow() {
		return new Date().getTime();
	}

	@Override
	public void addMessage(Message message) {
		messages.add(message);

	}

}
