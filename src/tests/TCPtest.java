package tests;

import org.junit.Test;

import threads.CommunicationThreads;
import threads.Plane;

public class TCPtest {

	@Test
	public void test() {

		Thread Serveur = new CommunicationThreads(2341);
		Thread plane = new Plane(0, 0, "Vol000", "Bâle", "01:15:00");

	}

}
