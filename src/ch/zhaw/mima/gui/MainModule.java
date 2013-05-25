package ch.zhaw.mima.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ch.zhaw.mima.App;
import ch.zhaw.mima.addresses.EmailAddress;
import ch.zhaw.mima.addresses.PhoneAddress;
import ch.zhaw.mima.addresses.PrinterAddress;
import ch.zhaw.mima.message.Email;
import ch.zhaw.mima.message.EmailImpl;
import ch.zhaw.mima.message.PrinterJobImpl;
import ch.zhaw.mima.message.SMSImpl;
import ch.zhaw.mima.message.reminder.EmailReminder;
import ch.zhaw.mima.validator.AddressValidatorException;

public class MainModule extends BaseModule implements ActionListener {

	public MainModule(App app) {
		super(app);
		
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 499999116029107784L;
	/**
   * @uml.property  name="buSms"
   * @uml.associationEnd  
   */
	private JButton buSms;
	/**
   * @uml.property  name="buMail"
   * @uml.associationEnd  
   */
	private JButton buMail;
	/**
   * @uml.property  name="buPrint"
   * @uml.associationEnd  
   */
	private JButton buPrint;
	/**
   * @uml.property  name="buMms"
   * @uml.associationEnd  
   */
	private JButton buMms;

	public void start() {
		// test();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// JPanel mainPanel = new JPanel();
		// mainPanel.setLayout(new BorderLayout());

		// create Buttons
		this.createButtons();

		// setSize
		this.setButtonSize(200, 20);
		
		// set commands
		this.setCommands();

		// set listener
		this.setActionListener();

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
	
	private void setButtonSize(int width, int height) {
		buSms.setSize(width, height);
		buMail.setSize(width, height);
		buPrint.setSize(width, height);
		buMms.setSize(width, height);
	}

	public void actionPerformed(ActionEvent arg0) {
		AbstractMessagingModule messageObject = null;
		// set recipient
		switch (arg0.getActionCommand()) {
		case "sms":
			messageObject = new SmsModule(getApp());
			break;
		case "mail":
			messageObject = new MailModule(getApp());
			break;
		case "mms":
			messageObject = new MmsModule(getApp());
			break;
		case "print":
			messageObject = new PrintModule(getApp());
			break;
		}
		messageObject.start();
	}
	
	

	private void test() {
		EmailImpl mail = new EmailImpl();
		mail.setText("hello world");
		mail.addAddress(new EmailAddress("macrozone@gmail.com"));
		mail.setSendTime(new Date().getTime()+20000l);
		try {
			getApp().getMessagingService().addMessage(mail);
		} catch (AddressValidatorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		EmailReminder mailReminder = new EmailReminder();
		mailReminder.setText("my reminder text");
		mailReminder.addAddress(new EmailAddress("macrozone2@gmail.com"));
		mailReminder.setOriginalMessage(mail);
		mailReminder.setSendTime(new Date().getTime()+5000l);
		try {
			getApp().getMessagingService().addMessage(mailReminder);
		} catch (AddressValidatorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SMSImpl sMSImpl = new SMSImpl();
		sMSImpl.setText("bla lol rofl lg marco");
		sMSImpl.addAddress(new PhoneAddress("07881876726"));
		sMSImpl.setSendTime(new Date().getTime()+8000l);
		try {
			getApp().getMessagingService().addMessage(sMSImpl);
		} catch (AddressValidatorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PrinterJobImpl print = new PrinterJobImpl();
		print.setText("bla lol rofl lg marco");
		print.setSendTime(new Date().getTime()+15000l);
		print.addAddress(new PrinterAddress("192.168.1.100"));
		try {
			getApp().getMessagingService().addMessage(print);
		} catch (AddressValidatorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
