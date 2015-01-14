package threads;

import data.DelayedTask;
import data.Hour;

public class Plane extends Thread {

	double xCurrentPos, yCurrentPos, xTargetPos, yTargetPos, xInitialPos,
			yInitialPos;
	double speed = 0;
	String flightName, targetName, timeOfDeparture;
	Hour h;

	public Plane(double xdepart, double ydepart, String flightName,
			String targetName, String timeOfDeparture) {
		xCurrentPos = xdepart;
		yCurrentPos = ydepart;

		xInitialPos = xdepart;
		yInitialPos = ydepart;

		this.flightName = flightName;
		this.targetName = targetName;
		this.timeOfDeparture = timeOfDeparture;
		this.h = new Hour();
	}

	public void run() {

		int timeInMS = h.getHourInMS(this.timeOfDeparture);

		DelayedTask dTask = new DelayedTask(timeInMS, flightName, targetName,
				timeOfDeparture);

		dTask.dTask();
	}
}
