package threads;

import java.util.ArrayList;

import airport.Airport;
import data.DelayedTask;
import data.Hour;
import data.Reader;

public class Plane extends Thread {

	public double xCurrentPos, yCurrentPos, zCurrentPos, xInitialPos, yInitialPos;
	public int[] targetData;
	public double speed = 0;
	public double theta = 0;
	String timeOfDeparture;

	
	public String flightName;
	String targetName;
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
		
		Reader r = new Reader();
		targetData = new int[3];
		targetData = r.findAirportSocket(targetName);
		System.out.println("[" + flightName + "] : Xpos target " + targetData[0]);
		System.out.println("[" + flightName + "] : Ypos target " + targetData[1]);
		System.out.println("[" + flightName + "] : Socket " + targetData[2]);

	}

	public void run() {

		int timeInMS = h.getHourInMS(this.timeOfDeparture);

		DelayedTask dTask = new DelayedTask(timeInMS, flightName, targetName,
				timeOfDeparture, airport,this);

		dTask.time();
		dTask.dTask();
	}
}
