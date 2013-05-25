package ch.zhaw.mima;

public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		App app = new App();
		app.start();
	}

	private MessagingService messagingService;

	public App() {
		
		setMessagingService(new MessagingService());

	}

	public void start() {
		MainModule mainModule = new MainModule(this);
		mainModule.start();
	}

	public MessagingService getMessagingService() {
		return messagingService;
	}

	public void setMessagingService(MessagingService messagingService) {
		this.messagingService = messagingService;
	}
	
	

}
