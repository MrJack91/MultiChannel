package ch.zhaw.mima.queue;

import ch.zhaw.mima.message.Sendable;
import ch.zhaw.mima.sender.MessageSender;

/**
 * 
 */

/**
 * @author michael
 *
 */
public interface MessageQueue<T extends Sendable<?>> {
	
	public void processQueue(MessageSender<T> sender);
	
	public void addSendable(T sendable);

	
}
