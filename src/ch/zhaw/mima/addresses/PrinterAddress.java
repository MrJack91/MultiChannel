package ch.zhaw.mima.addresses;


public class PrinterAddress implements Address{
	
	
	/**
   * @uml.property  name="printerIP"
   */
	private String printerIP;

	public PrinterAddress(String printerIP)
	{
		this.setPrinterIP(printerIP);
	}

	/**
   * @return
   * @uml.property  name="printerIP"
   */
	public String getPrinterIP() {
		return printerIP;
	}

	@Override
	public String toString() {
		return "PrinterAddress [printerIP=" + printerIP + "]";
	}

	/**
   * @param printerIP
   * @uml.property  name="printerIP"
   */
	public void setPrinterIP(String printerIP) {
		this.printerIP = printerIP;
	}


}
