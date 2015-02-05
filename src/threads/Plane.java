package threads;

import airport.Airport;
import data.DelayedTask;
import data.Hour;
import data.InOut;

public class Plane extends Thread {

	public double xCurrentPos, yCurrentPos, zCurrentPos, xInitialPos, yInitialPos;
	public int[] targetData; // 0 : xpos, 1 : ypos et 2 : numero de port du serveur TCP
	public double speed = 0;
	public double theta = 0;
	public double alphaTakeOff;
	public String timeOfDeparture;
	public String flightName;
	public String targetName;
	public Hour h;
	public int time;
	public Airport airport;

	public Plane(double xdepart, double ydepart, String flightName,
			String targetName, String timeOfDeparture, Airport airport) {
		xCurrentPos = xdepart;
		yCurrentPos = ydepart;
		zCurrentPos = 0;
		
		xInitialPos = xdepart;
		yInitialPos = ydepart;
		
		this.flightName = flightName;
		this.targetName = targetName;
		this.timeOfDeparture = timeOfDeparture;
		this.h = new Hour();
		this.airport = airport;
		
		InOut r = new InOut();
		targetData = new int[3];
		targetData = r.findAirportSocket(targetName);
				
		System.out.println("[" + flightName + "] : Xpos target " + targetData[0]);
		System.out.println("[" + flightName + "] : Ypos target " + targetData[1]);
		System.out.println("[" + flightName + "] : Socket " + targetData[2]);

	}

	public void run() {

		int timeInMS = h.getHourInMS(this.timeOfDeparture);

		DelayedTask dTask = new DelayedTask(timeInMS,this);

		dTask.time();
		dTask.dTask();
	}
}
