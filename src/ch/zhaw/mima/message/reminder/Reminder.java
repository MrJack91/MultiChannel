package ch.zhaw.mima.message.reminder;

import ch.zhaw.mima.message.Message;

/**
 * 
 */

/**
 * @author michael
 * @param <T>
 *
 */
public interface Reminder<T extends Message<?>> {
	
	public T getOriginalMessage();
	
	public void setOriginalMessage(T message);
	
	
}
