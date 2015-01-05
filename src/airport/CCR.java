package airport;

import threads.CommunicationThreads;

public class CCR extends Airport {

	public CCR(double xPos, double yPos) {
		// TODO Auto-generated method stub
		this.xPos = xPos;
		this.yPos = yPos;
	}

	/*
	 * create a Server thread for the CCR
	 */
	public void create() {
		// TODO Auto-generated method stub
		CommunicationThreads ServerThread = new CommunicationThreads(2341);
		ServerThread.start();

	}

	public void writeFile() {
		// TODO Auto-generated method stub

	}

}
