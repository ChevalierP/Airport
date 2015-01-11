package data;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import transmission.Client;
import transmission.Transmission;

public class DelayedTask {

	int delay = 0; // en ms
	String flightName;
	String targetName;
	String timeOfDeparture;

	public DelayedTask(int delay, String flightName, String targetName,
			String timeOfDeparture) {
		this.delay = delay;
		this.flightName = flightName;
		this.targetName = targetName;
		this.timeOfDeparture = timeOfDeparture;
	}

	public void dTask() {

		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			public void run() {
				System.out.println(flightName + ":" + " Ready to go !");
				System.out.println("To " + targetName);
				System.out.println("At " + timeOfDeparture);

				Transmission planeClient = new Client(2341);
				try {
					planeClient.create();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}, delay / 100);
	}
}
