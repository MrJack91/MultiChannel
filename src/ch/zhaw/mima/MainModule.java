package ch.zhaw.mima;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ch.zhaw.mima.gui.AbstractMessagingModule;
import ch.zhaw.mima.gui.MailModule;
import ch.zhaw.mima.gui.MmsModule;
import ch.zhaw.mima.gui.PrintModule;
import ch.zhaw.mima.gui.SmsModule;

public class MainModule extends BaseModule implements ActionListener {

	public MainModule(App app) throws HeadlessException {
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
}
