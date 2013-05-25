package ch.zhaw.mima;

import ch.zhaw.mima.gui.MainModule;
import ch.zhaw.mima.queue.Ticker;

public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		App app = new App();
		app.start();
	}

	/**
   * @uml.property  name="messagingService"
   * @uml.associationEnd  multiplicity="(1 1)"
   */
	private MessagingService messagingService;
	/**
   * @uml.property  name="ticker"
   * @uml.associationEnd  multiplicity="(1 1)"
   */
	private Ticker ticker;

	public App() {
		ticker = new Ticker();
	

		messagingService = new MessagingService();
		
		
		ticker.addTickable(messagingService);

	}


	public void start() {
		ticker.start();
		MainModule mainModule = new MainModule(this);
		mainModule.start();
	}

	/**
   * @return
   * @uml.property  name="messagingService"
   */
	public MessagingService getMessagingService() {
		return messagingService;
	}

	
	

}
