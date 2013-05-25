package ch.zhaw.mima.message;

/**
 * 
 */

/**
 * @author michael
 * @param <T>
 *
 */
public interface Reminder<T extends Message<?>>{
	
	public T getOriginalMessage();
	
	public void setOriginalMessage(T message);
	
	
}
