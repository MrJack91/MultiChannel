package ch.zhaw.mima.message;

import java.util.ArrayList;
import java.util.List;

import ch.zhaw.mima.addresses.Address;

/**
 * 
 */

/**
 * @author michael
 * 
 */
public abstract class AbstractMessageImpl<T extends Address> implements Message<T> {

	private String text;
	private List<T> addresses;
	private int sendTime;

	@Override
	public String toString() {
		return "Message [text=" + text + ", addresses=" + addresses
				+ ", sendTime=" + sendTime + "]";
	}

	public AbstractMessageImpl() {
		addresses = new ArrayList<T>();
	}

	public String getText() {
		return text;
	}

	@Override
	public List<T> getAdresses() {
		return addresses;
	}

	@Override
	public long getSendTime() {
		return sendTime;
	}

	@Override
	public void setText(String text) {
		this.text = text;

	}

	@Override
	public void addAddress(T address) {
		addresses.add(address);

	}

	@Override
	public void setSendTime(int sendTime) {
		this.sendTime = sendTime;
	}
	
	

}
