package ch.zhaw.mima.addresses;

public class PrinterAddress implements Address{
	
	
	private String printerIP;

	public PrinterAddress(String printerIP)
	{
		this.setPrinterIP(printerIP);
	}

	public String getPrinterIP() {
		return printerIP;
	}

	@Override
	public String toString() {
		return "PrinterAddress [printerIP=" + printerIP + "]";
	}

	public void setPrinterIP(String printerIP) {
		this.printerIP = printerIP;
	}

}
