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
public abstract class AbstractMessageImpl implements Message {

	private String text;
	private List<Address> addresses;
	private int sendTime;

	@Override
	public String toString() {
		return "Message [text=" + text + ", addresses=" + addresses
				+ ", sendTime=" + sendTime + "]";
	}

	public AbstractMessageImpl() {
		addresses = new ArrayList<Address>();
	}

	public String getText() {
		return text;
	}

	@Override
	public List<Address> getAdresses() {
		return addresses;
	}

	@Override
	public int getSendTime() {
		return sendTime;
	}

	@Override
	public void setText(String text) {
		this.text = text;

	}

	@Override
	public void addAddress(Address recipient) {
		addresses.add(recipient);

	}

	@Override
	public void setSendTime(int sendTime) {
		this.sendTime = sendTime;
	}

}
