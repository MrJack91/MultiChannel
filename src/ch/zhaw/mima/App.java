package ch.zhaw.mima;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import ch.zhaw.mima.gui.AbstractMessagingModule;
import ch.zhaw.mima.gui.SmsModule;

public class App implements ActionListener {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		App app = new App();
		app.startup();

	}

	public void startup() {
		
		JFrame mainFrame = new JFrame();
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// JPanel mainPanel = new JPanel();
		// mainPanel.setLayout(new BorderLayout());
		
		// create Buttons
		JButton buSms = new JButton("SMS versenden");
		JButton buMail = new JButton("Email versenden");
		JButton buPrint = new JButton("Print versenden");
		JButton buMms = new JButton("Brief versenden");
		
		// set commands
		buSms.setActionCommand("sms");
		buMail.setActionCommand("mail");
		buPrint.setActionCommand("print");
		buMms.setActionCommand("mms");
		
		// set listener
		buSms.addActionListener(this);
		buMail.addActionListener(this);
		buPrint.addActionListener(this);
		buMms.addActionListener(this);
		
		// Add buttons to panel
		JPanel panelMsgType = new JPanel();
		panelMsgType.setLayout(new BoxLayout(panelMsgType, BoxLayout.Y_AXIS));
		panelMsgType.add(buSms);
		panelMsgType.add(buMail);
		panelMsgType.add(buPrint);
		panelMsgType.add(buMms);
		
		// add panel to main frame
		// mainPanel.add(panelMsgType);
		
		// show frame
		// mainFrame.getContentPane().add(BorderLayout.CENTER, mainPanel);
		mainFrame.getContentPane().add(panelMsgType);
		mainFrame.setSize(500, 220);
		mainFrame.setVisible(true);
	}

	public void actionPerformed(ActionEvent arg0) {
		AbstractMessagingModule messageModul = null;
		
		// set recipient
		switch (arg0.getActionCommand()) {
			case "sms":
				messageModul = new SmsModule();
				break;
			case "mail":
				
				break;
			case "mms":
				
				break;
			case "print":
				
				break;
		}
		
		messageModul.start();
		
		
		/*
		// set text from button to new frame
		JFrame mainFrame = new JFrame(((JButton) arg0.getSource()).getText());
		// mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// JPanel mainPanel = new JPanel();
		// mainPanel.setLayout(new BorderLayout());
		
		// content for all elements
		JPanel paEditor = new JPanel();
		paEditor.setLayout(new BoxLayout(paEditor, BoxLayout.Y_AXIS));
		
		// set recipient
		switch (arg0.getActionCommand()) {
			case "sms":
			case "mail":
				JLabel lbRecipient = new JLabel("Empfänger");
				JTextArea taRecipient = new JTextArea();
				paEditor.add(lbRecipient);
				paEditor.add(taRecipient);
				break;
			case "letter":
				JLabel lbAddress = new JLabel("Adresse");
				JTextArea taAddress = new JTextArea();
				paEditor.add(lbAddress);
				paEditor.add(taAddress);
				break;
		}
		
		// set message input
		JLabel lbText = new JLabel("Text");
		JTextArea taText = new JTextArea();
		taText.setSize(30, 30);
		paEditor.add(lbText);
		paEditor.add(taText);
		
		
		// add panel to main frame
		// mainPanel.add(paEditor);
		
		// show frame
		// mainFrame.getContentPane().add(BorderLayout.CENTER, mainPanel);
		mainFrame.getContentPane().add(paEditor);
		mainFrame.setSize(500, 700);
		mainFrame.setVisible(true);
		mainFrame.toFront();
		mainFrame.setAlwaysOnTop(true);
		*/
	}
}
