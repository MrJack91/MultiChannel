package ch.zhaw.mima.message;

import java.util.List;

import ch.zhaw.mima.Recipient;

/**
 * 
 */

/**
 * @author michael
 * 
 */
public interface Message {
	public String getText();

	public List<Recipient> getRecipient();

	public int getSendTime();

	public void send();
	
	
	public void setText(String text);
	
	public void addRecipient(Recipient recipient);
	
	public void setSendTime(int sendTime);
	


}
