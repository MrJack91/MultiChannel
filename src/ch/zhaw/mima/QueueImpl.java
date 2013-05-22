package ch.zhaw.mima;

import java.util.Date;
import java.util.List;

import ch.zhaw.mima.addresses.Address;
import ch.zhaw.mima.message.Sendable;
import ch.zhaw.mima.validator.AddressValidatorException;

public class QueueImpl implements Queue {

	private List<Sendable<? extends Address>> sendables;

	@Override
	public void processQueue() {

		for (Sendable<? extends Address> oneSendable : sendables) {
			if (oneSendable.getSendTime() <= getNow()) {
				oneSendable.send();
			}
		}

	}

	private long getNow() {
		return new Date().getTime();
	}

	@Override
	public void addSendable(Sendable<? extends Address> sendable)
			throws AddressValidatorException {
		for (Address address : sendable.getAdresses())
			address.validate();
		sendables.add(sendable);

	}

}
