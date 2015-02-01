package threads;

import airport.Airport;
import data.DelayedTask;
import data.Hour;

public class Plane extends Thread {

	public double xCurrentPos, yCurrentPos, zCurrentPos, xTargetPos, yTargetPos, xInitialPos,
			yInitialPos;
	public double speed = 0;
	public String flightName;
	String targetName;
	String timeOfDeparture;
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
	}

	public void run() {

		int timeInMS = h.getHourInMS(this.timeOfDeparture);

		DelayedTask dTask = new DelayedTask(timeInMS, flightName, targetName,
				timeOfDeparture, airport,this);

		dTask.time();
		dTask.dTask();
	}
}
