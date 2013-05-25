package ch.zhaw.mima.message;

import java.util.List;
import java.util.concurrent.Delayed;

import ch.zhaw.mima.addresses.Address;

public interface Sendable<T extends Address>{

	public void send();

	public long getSendTime();

	public void setSendTime(int sendTime);

	public List<T> getAdresses();

	public void addAddress(T address);

}
