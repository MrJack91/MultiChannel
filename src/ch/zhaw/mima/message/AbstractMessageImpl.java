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

	/**
   * @uml.property  name="text"
   */
	private String text;
	/**
   * @uml.property  name="addresses"
   * @uml.associationEnd  multiplicity="(0 -1)" elementType="ch.zhaw.mima.addresses.Address"
   */
	private List<T> addresses;
	/**
   * @uml.property  name="sendTime"
   */
	private int sendTime;

	@Override
	public String toString() {
		return "Message [text=" + text + ", addresses=" + addresses
				+ ", sendTime=" + sendTime + "]";
	}

	public AbstractMessageImpl() {
		addresses = new ArrayList<T>();
	}

	/**
   * @return
   * @uml.property  name="text"
   */
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

	/**
   * @param text
   * @uml.property  name="text"
   */
	@Override
	public void setText(String text) {
		this.text = text;

	}

	@Override
	public void addAddress(T address) {
		addresses.add(address);

	}

	/**
   * @param sendTime
   * @uml.property  name="sendTime"
   */
	@Override
	public void setSendTime(int sendTime) {
		this.sendTime = sendTime;
	}

}
