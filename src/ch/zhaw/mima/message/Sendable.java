package ch.zhaw.mima.message;

import java.util.List;

import ch.zhaw.mima.addresses.Address;

public interface Sendable<T extends Address> {

	public long getSendTime();

	public void setSendTime(long sendTime);
	
	public String getSendTimeFormatted();

	public List<T> getAdresses();

	public void addAddress(T address);

}
