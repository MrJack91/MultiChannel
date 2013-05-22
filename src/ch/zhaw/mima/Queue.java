package ch.zhaw.mima;
import ch.zhaw.mima.message.Message;

/**
 * 
 */

/**
 * @author michael
 *
 */
public interface Queue {
	
	public void processQueue();
	
	public void addMessage(Message message);

}
