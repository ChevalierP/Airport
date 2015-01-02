package airport;

import java.util.concurrent.Semaphore;

public class CCR_Ajaccio {

	static Semaphore waitingAreaAlt500;
	static Semaphore waitingAreaAlt1000;
	static Semaphore waitingAreaAlt1500;
	static Semaphore waitingAreaAlt2000;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		waitingAreaAlt500 = new Semaphore(5);
		waitingAreaAlt1000 = new Semaphore(5);
		waitingAreaAlt1500 = new Semaphore(5);
		waitingAreaAlt2000 = new Semaphore(5);
		
		APP_Ajaccio app = new APP_Ajaccio();
		app.getInputData();

		app.sendData();
	}

}
