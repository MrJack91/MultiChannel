package ch.zhaw.mima.sender;

import ch.zhaw.mima.message.PrinterJob;

public class PrinterJobSender implements MessageSender<PrinterJob> {

	@Override
	public void send(PrinterJob message) {
		System.out.println("sending printerJob "+message);
		
	}

}
