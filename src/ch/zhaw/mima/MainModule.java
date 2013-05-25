package ch.zhaw.mima;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ch.zhaw.mima.gui.ModuleSms;

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
		buMms = new JButton("Brief versenden");
	}

	public void actionPerformed(ActionEvent arg0) {
		System.out.println(arg0.getActionCommand());

		// set recipient
		switch (arg0.getActionCommand()) {
		case "sms":
			ModuleSms sms = new ModuleSms();
			break;
		case "mail":

			break;
		case "mms":

			break;
		case "print":

			break;
		}
		/*
		 * // set text from button to new frame JFrame mainFrame = new
		 * JFrame(((JButton) arg0.getSource()).getText()); //
		 * setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 * 
		 * // JPanel mainPanel = new JPanel(); // mainPanel.setLayout(new
		 * BorderLayout());
		 * 
		 * // content for all elements JPanel paEditor = new JPanel();
		 * paEditor.setLayout(new BoxLayout(paEditor, BoxLayout.Y_AXIS));
		 * 
		 * // set recipient switch (arg0.getActionCommand()) { case "sms": case
		 * "mail": JLabel lbRecipient = new JLabel("Empfänger"); JTextArea
		 * taRecipient = new JTextArea(); paEditor.add(lbRecipient);
		 * paEditor.add(taRecipient); break; case "letter": JLabel lbAddress =
		 * new JLabel("Adresse"); JTextArea taAddress = new JTextArea();
		 * paEditor.add(lbAddress); paEditor.add(taAddress); break; }
		 * 
		 * // set message input JLabel lbText = new JLabel("Text"); JTextArea
		 * taText = new JTextArea(); taText.setSize(30, 30);
		 * paEditor.add(lbText); paEditor.add(taText);
		 * 
		 * 
		 * // add panel to main frame // mainPanel.add(paEditor);
		 * 
		 * // show frame // getContentPane().add(BorderLayout.CENTER,
		 * mainPanel); getContentPane().add(paEditor); setSize(500, 700);
		 * setVisible(true); toFront(); setAlwaysOnTop(true);
		 */
	}
}
