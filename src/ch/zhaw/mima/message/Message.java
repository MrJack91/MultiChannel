package ch.zhaw.mima.message;

import java.util.List;

import ch.zhaw.mima.addresses.Address;

/**
 * 
 */

/**
 * @author michael
 * 
 */
public interface Message<T extends Address> {
	public String getText();

	public List<Address> getAdresses();

	public int getSendTime();

	public void send();
	
	
	public void setText(String text);
	
	public void addAddress(T address);
	
	public void setSendTime(int sendTime);
	


}
