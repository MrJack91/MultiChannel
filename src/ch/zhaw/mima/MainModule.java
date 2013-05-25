package ch.zhaw.mima;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ch.zhaw.mima.addresses.EmailAddress;
import ch.zhaw.mima.addresses.PhoneAddress;
import ch.zhaw.mima.addresses.PrinterAddress;
import ch.zhaw.mima.gui.AbstractMessagingModule;
import ch.zhaw.mima.gui.MailModule;
import ch.zhaw.mima.gui.MmsModule;
import ch.zhaw.mima.gui.PrintModule;
import ch.zhaw.mima.gui.SmsModule;
import ch.zhaw.mima.message.Email;
import ch.zhaw.mima.message.EmailImpl;
import ch.zhaw.mima.message.PrinterJob;
import ch.zhaw.mima.message.PrinterJobImpl;
import ch.zhaw.mima.message.SMS;
import ch.zhaw.mima.message.SMSImpl;
import ch.zhaw.mima.validator.AddressValidatorException;

public class MainModule extends BaseModule implements ActionListener {

	public MainModule(App app) throws HeadlessException {
		super(app);
		
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 499999116029107784L;
	private JButton buSms;
	private JButton buMail;
	private JButton buPrint;
	private JButton buMms;

	public void start() {
		test();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// JPanel mainPanel = new JPanel();
		// mainPanel.setLayout(new BorderLayout());

		// create Buttons
		createButtons();

		// set commands
		setCommands();

		// set listener
		setActionListener();

		// Add buttons to panel
		JPanel panelMsgType = new JPanel();
		panelMsgType.setLayout(new BoxLayout(panelMsgType, BoxLayout.Y_AXIS));
		panelMsgType.add(buSms);
		panelMsgType.add(buMail);
		panelMsgType.add(buPrint);
		panelMsgType.add(buMms);

		// show frame
		// getContentPane().add(BorderLayout.CENTER, mainPanel);
		getContentPane().add(panelMsgType);
		setSize(500, 220);
		setVisible(true);
	}

	private void setActionListener() {
		buSms.addActionListener(this);
		buMail.addActionListener(this);
		buPrint.addActionListener(this);
		buMms.addActionListener(this);
	}

	private void setCommands() {
		buSms.setActionCommand("sms");
		buMail.setActionCommand("mail");
		buPrint.setActionCommand("print");
		buMms.setActionCommand("mms");
	}

	private void createButtons() {
		buSms = new JButton("SMS versenden");
		buMail = new JButton("Email versenden");
		buPrint = new JButton("Print versenden");
		buMms = new JButton("MMS versenden");
	}

	public void actionPerformed(ActionEvent arg0) {
		AbstractMessagingModule messageObject = null;
		// set recipient
		switch (arg0.getActionCommand()) {
		case "sms":
			messageObject = new SmsModule();
			break;
		case "mail":
			messageObject = new MailModule();
			break;
		case "mms":
			messageObject = new MmsModule();
			break;
		case "print":
			messageObject = new PrintModule();
			break;
		}
		messageObject.start();
	}
	
	

	private void test() {
		Email mail = new EmailImpl();
		mail.setText("hello world");
		mail.addAddress(new EmailAddress("macrozone@gmail.com"));
		mail.setSendTime(new Date().getTime()+5000l);
		try {
			getApp().getMessagingService().addMessage(mail);
		} catch (AddressValidatorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SMS sms = new SMSImpl();
		sms.setText("bla lol rofl lg marco");
		sms.addAddress(new PhoneAddress("07881876726"));
		try {
			getApp().getMessagingService().addMessage(sms);
		} catch (AddressValidatorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PrinterJob print = new PrinterJobImpl();
		print.setText("bla lol rofl lg marco");
		print.setSendTime(new Date().getTime()+7000l);
		print.addAddress(new PrinterAddress("192.168.1.100"));
		try {
			getApp().getMessagingService().addMessage(print);
		} catch (AddressValidatorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
