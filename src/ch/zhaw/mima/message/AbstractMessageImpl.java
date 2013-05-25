package ch.zhaw.mima.message;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ch.zhaw.mima.addresses.Address;

/**
 * 
 */

/**
 * @author michael
 * 
 */
public abstract class AbstractMessageImpl<T extends Address> implements
		Message<T> {

	private String text;
	private List<T> addresses;
	private long sendTime;

	@Override
	public String toString() {
		return "Message [text=" + getText() + ", addresses=" + getAdresses()
				+ ", sendTime=" + getSendTimeFormatted() + "]";
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
	public String getSendTimeFormatted() {
		return new Date(sendTime).toString();
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
	public void setSendTime(long sendTime) {
		this.sendTime = sendTime;
	}

}
