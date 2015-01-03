package threads;

import java.net.InetAddress;
import java.net.UnknownHostException;

import transmission.Client;
import transmission.Transmission;

public class Plane extends Thread {

	double xCurrentPos, yCurrentPos, xTargetPos, yTargetPos, xInitialPos,
			yInitialPos;
	double speed = 0;
	String flightName, targetName, timeOfDeparture;

	public Plane(double xdepart, double ydepart, String flightName,
			String targetName, String timeOfDeparture) {
		xCurrentPos = xdepart;
		yCurrentPos = ydepart;

		xInitialPos = xdepart;
		yInitialPos = ydepart;

		this.flightName = flightName;
		this.targetName = targetName;
		this.timeOfDeparture = timeOfDeparture;
	}

	public void run() {

		System.out.println(this.flightName + ":" + " Ready to go !");
		System.out.println("To " + targetName);
		System.out.println("At " + timeOfDeparture);
		
		try {
			Transmission planeClient = new Client(2341, InetAddress.getLocalHost());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
