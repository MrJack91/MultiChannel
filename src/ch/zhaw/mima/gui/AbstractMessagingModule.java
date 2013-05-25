/**
 * 
 */
package ch.zhaw.mima.gui;

import java.awt.Component;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import org.freixas.jcalendar.DateEvent;
import org.freixas.jcalendar.DateListener;
import org.freixas.jcalendar.JCalendarCombo;

import ch.zhaw.mima.App;
import ch.zhaw.mima.addresses.Address;
import ch.zhaw.mima.message.Message;

/**
 * @author michael
 * 
 */
public abstract class AbstractMessagingModule<T extends Message<? extends Address>> extends BaseModule {

	/**
	 * @param app
	 * @throws HeadlessException
	 */
  public AbstractMessagingModule(App app) throws HeadlessException {
	  super(app);
  }

	/**
	 * 
	 */
  private static final long serialVersionUID = 1833405701153538705L;
	/**
	 * content the frame in it self
	 * 
	 * @uml.property name="mainFrame"
	 * @uml.associationEnd
	 */
	protected JFrame mainFrame;
	/**
	 * the full editor is in this panel
	 * 
	 * @uml.property name="paEditor"
	 * @uml.associationEnd
	 */
	protected JPanel paEditor;

	/**
	 * the title of this message frame
	 * 
	 * @uml.property name="frameTitle"
	 */
	protected String frameTitle;

	private JTextArea taRecipient;
	private JTextArea taText;
	private JCalendarCombo calendar;

	public void start() {
		this.init();
		this.createHeader();
		this.createBody();
		this.createFooter();
		this.showFrame();
	}

	/**
	 * Initialize a message frame
	 * 
	 * @param framename
	 *          name of new frame
	 */
	protected void init() {
		mainFrame = new JFrame(this.frameTitle);
		// mainFrame.setLayout(new FlowLayout());
		// mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // sonst
		// schliesst das ganze Programm

		// content for all elements
		paEditor = new JPanel();
		paEditor.setLayout(new BoxLayout(paEditor, BoxLayout.Y_AXIS));
		// paEditor.setLayout(new FlowLayout());
	}

	/**
	 * write the header to the gui default is the recipients input as textarea
	 */
	protected void createHeader() {
		// Recipient
		this.createRecipientInput();
	}

	/**
	 * write the body to the gui default is the message textarea
	 */
	protected void createBody() {
		// text
		this.createMessageInput();
	}

	/**
	 * write the footer to the gui no defaults at time
	 */
	protected void createFooter() {
		this.createSendButton();
	}

	protected void showFrame() {
		// show frame
		mainFrame.getContentPane().add(paEditor);
		mainFrame.setSize(500, 700);
		mainFrame.setVisible(true);
		mainFrame.toFront();
		// mainFrame.setAlwaysOnTop(true);
	}

	/**
	 * write the recipient to the gui
	 */
	protected void createRecipientInput() {
		JLabel lbRecipient = new JLabel("Empfänger");
		lbRecipient.setAlignmentX(Component.LEFT_ALIGNMENT);
		taRecipient = new JTextArea();
		taRecipient.setAlignmentX(Component.LEFT_ALIGNMENT);
		// make this scrollable
		JScrollPane spRecipient = new JScrollPane(taRecipient,
		    JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
		    JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		spRecipient.setAlignmentX(Component.LEFT_ALIGNMENT);
		this.paEditor.add(lbRecipient);
		this.paEditor.add(spRecipient);
	}

	protected void createMessageInput() {
		// set message input
		JLabel lbText = new JLabel("Text");
		lbText.setAlignmentX(Component.LEFT_ALIGNMENT);
		taText = new JTextArea();
		taText.setAlignmentX(Component.LEFT_ALIGNMENT);
		JScrollPane spText = new JScrollPane(taText,
		    JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
		    JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		spText.setAlignmentX(Component.LEFT_ALIGNMENT);
		this.paEditor.add(lbText);
		this.paEditor.add(spText);
	}

	protected void createSendButton() {
		// set message input
		JLabel lbTime = new JLabel("Zeit:");
		lbTime.setAlignmentX(Component.LEFT_ALIGNMENT);

		Border etchedBorder = BorderFactory.createEtchedBorder();
		Border emptyBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		Border compoundBorder = BorderFactory.createCompoundBorder(etchedBorder,
		    emptyBorder);

		calendar = new JCalendarCombo(
		    Calendar.getInstance(Locale.GERMAN), Locale.GERMAN,
		    JCalendarCombo.DISPLAY_DATE | JCalendarCombo.DISPLAY_TIME, true);
		
		calendar.setBorder(compoundBorder);
		//calendar.addDateListener(new MyDateListener());
		
		JButton buSend = new JButton("senden");
		buSend.setAlignmentX(Component.LEFT_ALIGNMENT);
		buSend.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				sendMessage();
				
			}
		});

		paEditor.add(lbTime);
		paEditor.add(calendar);
		paEditor.add(buSend);
	}

	/**
	 * 
	 */
  protected void sendMessage() {
  	T message = createMessage();
  	message.setText(taText.getText());
  	
  	// calendar.getTime()
  	
  	addAddressesToMessage(taRecipient.getText(), message);

  	putMessageInQueue(message);
	}

	/**
	 * @param message
	 */
  protected abstract void addAddressesToMessage(String addressString, T message);

	/**
	 * @param message
	 */
  protected abstract void putMessageInQueue(T message);
  

	/**
	 * 
	 */
  protected abstract T createMessage();
	  
  

	// **********************************************************************
	// Inner Classes
	// **********************************************************************

	 private class MyDateListener implements DateListener {

		public void dateChanged(DateEvent e) {
			Calendar c = e.getSelectedDate();
			if (c != null) {
				System.out.println(c.getTime());
			} else {
				System.out.println("No time selected.");
			}
		}

	}

	// **********************************************************************
	// End Inner Classes
	// **********************************************************************

}