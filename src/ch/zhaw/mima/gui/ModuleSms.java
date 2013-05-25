/**
 * 
 */
package ch.zhaw.mima.gui;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import sun.security.krb5.internal.PAEncTSEnc;

/**
 * @author michael
 *
 */
public class ModuleSms {

	/**
	 * content the frame in it self
	 */
	protected JFrame mainFrame;
	/**
	 * the full editor is in this panel
	 */
	protected JPanel paEditor;
	
	/**
	 * construct
	 */
	public ModuleSms() {
		this.init("SMS versenden");
		
	}
	
	/**
	 * Initialize a message frame
	 * @param framename name of new frame
	 */
	protected void init(String framename) {
		mainFrame = new JFrame(framename);
		// mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // sonst schliesst das ganze Programm
		
		// content for all elements
		paEditor = new JPanel();
		paEditor.setLayout(new BoxLayout(paEditor, BoxLayout.Y_AXIS));
	}
	
	/**
	 * write the header to the gui
	 * default is the recipients input as textarea
	 */
	protected void createHeader() {
		// Recipient
		this.createRecipientInput();
	}
	
	/**
	 * write the body to the gui
	 * default is the message textarea
	 */
	protected void createBody() {
		// text
		this.createMessageInput();
	}
	
	/**
	 * write the footer to the gui
	 * no defaults at time
	 */
	protected void createFooter() {
		
	}
	
	protected void showFrame() {
	// show frame
			// mainFrame.getContentPane().add(BorderLayout.CENTER, mainPanel);
			mainFrame.getContentPane().add(paEditor);
			mainFrame.setSize(500, 700);
			mainFrame.setVisible(true);
			mainFrame.toFront();
			mainFrame.setAlwaysOnTop(true);
	}
	
	/**
	 * write the recipient to the gui
	 */
	protected void createRecipientInput() {
		JLabel lbRecipient = new JLabel("Empfänger");
		JTextArea taRecipient = new JTextArea();
		this.paEditor.add(lbRecipient);
		this.paEditor.add(taRecipient);
	}
	
	
	protected void createMessageInput() {
		// set message input
		JLabel lbText = new JLabel("Text");
		JTextArea taText = new JTextArea();
		taText.setSize(30, 30);
		this.paEditor.add(lbText);
		this.paEditor.add(taText);
	}
	
}
