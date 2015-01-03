package airport;

import java.util.concurrent.Semaphore;

import threads.CommunicationThreads;

public class CCR_Ajaccio {

	static Semaphore waitingAreaAlt500;
	static Semaphore waitingAreaAlt1000;
	static Semaphore waitingAreaAlt1500;
	static Semaphore waitingAreaAlt2000;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CommunicationThreads ServeurThread = new CommunicationThreads(2341);
		System.out.println("thread créé");
		ServeurThread.run();

		waitingAreaAlt500 = new Semaphore(5);
		waitingAreaAlt1000 = new Semaphore(5);
		waitingAreaAlt1500 = new Semaphore(5);
		waitingAreaAlt2000 = new Semaphore(5);

		APP_Ajaccio app = new APP_Ajaccio();
		System.out.println("APP créé");
		app.getInputData();

		app.sendData();

	}

}
