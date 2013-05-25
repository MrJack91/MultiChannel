package ch.zhaw.mima.message;


public class AbstractReminderImpl<T extends Message<?>> implements Reminder<T> {

	private T originalMessage;

	@Override
	public T getOriginalMessage() {
		return originalMessage;
	}

	@Override
	public void setOriginalMessage(T message) {
		originalMessage = message;

	}

}
