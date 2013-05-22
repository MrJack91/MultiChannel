package ch.zhaw.mima.addresses;

public class PhoneAddress implements Address{

	protected String number;

	public PhoneAddress(String number) {
	
		super();
		this.number = number;
	}

	public String getNumber() {
		return number;
	}

	@Override
	public String toString() {
		return "PhoneAddress [number=" + number + "]";
	}

}