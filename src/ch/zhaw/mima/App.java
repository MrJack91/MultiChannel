package ch.zhaw.mima;

import ch.zhaw.mima.queue.Ticker;

public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		App app = new App();
		app.start();
	}

	private MessagingService messagingService;
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

	public MessagingService getMessagingService() {
		return messagingService;
	}

	
	

}
