package ch.zhaw.mima.addresses;



public class PhoneAddress implements Address{

	/**
   * @uml.property  name="number"
   */
	protected String number;

	public PhoneAddress(String number) {
	
		super();
		this.number = number;
	}

	/**
   * @return
   * @uml.property  name="number"
   */
	public String getNumber() {
		return number;
	}

	@Override
	public String toString() {
		return "PhoneAddress [number=" + number + "]";
	}

	

	

}