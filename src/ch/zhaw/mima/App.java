package ch.zhaw.mima;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		
		// create Buttons
		JButton buSms = new JButton("SMS versenden");
		JButton buMail = new JButton("Email versenden");
		JButton buPrint = new JButton("Print versenden");
		JButton buLetter = new JButton("Brief versenden");
		
		// set commands
		buSms.setActionCommand("sms");
		buMail.setActionCommand("mail");
		buPrint.setActionCommand("print");
		buLetter.setActionCommand("letter");
		
		// set listener
		buSms.addActionListener(this);
		buMail.addActionListener(this);
		buPrint.addActionListener(this);
		buLetter.addActionListener(this);
		
		// Add buttons to panel
		JPanel panelMsgType = new JPanel();
		panelMsgType.setLayout(new BoxLayout(panelMsgType, BoxLayout.Y_AXIS));
		panelMsgType.add(buSms);
		panelMsgType.add(buMail);
		panelMsgType.add(buPrint);
		panelMsgType.add(buLetter);
		
		// add panel to main frame
		mainPanel.add(panelMsgType);
		
		// show frame
		mainFrame.getContentPane().add(BorderLayout.CENTER, mainPanel);
		mainFrame.setSize(500, 220);
		mainFrame.setVisible(true);
	}

	public void actionPerformed(ActionEvent arg0) {
		
		
		switch (arg0.getActionCommand()) {
			case "sms":
				
				break;
		}
		
	}
}
