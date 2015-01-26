package data;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import airport.Airport;
import threads.Plane;
import transmission.Client;
import transmission.Transmission;

public class DelayedTask {

	int delay = 0; // en ms
	String flightName;
	String targetName;
	String timeOfDeparture;
	Airport airport;
	Plane plane;

	public DelayedTask(int delay, String flightName, String targetName,
			String timeOfDeparture, Airport airport, Plane plane) {
		this.delay = delay;
		this.flightName = flightName;
		this.targetName = targetName;
		this.timeOfDeparture = timeOfDeparture;
		this.airport = airport;
		this.plane = plane;
	}

	public void dTask() {

		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			public void run() {
				System.out.println("\n" + flightName + ":" + " Ready to go !");
				System.out.println("To " + targetName);
				System.out.println("At " + timeOfDeparture + "\n");

				try {
					airport.waitingAreaAlt500.acquire();
					System.out.println("Acquire sur le cercle d'attente");
					airport.piste.acquire();
					System.out.println("Acquire sur la piste");
					
					 updateTask();
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}, delay / 100);
	}

	public void updateTask() {

		Timer timer = new Timer();
		final Position p = new Position();
		
		TimerTask task = new TimerTask() {
			public void run() {
				if(plane.speed < 300)
				{
				plane.xCurrentPos = p.xposTakeOfupdate(plane.xCurrentPos);
				plane.speed = p.speedTakeOfupdate(plane.speed);

				System.out.println("[" + flightName + " Xpos]" + plane.xCurrentPos);
				System.out.println("[" + flightName + " Speed]" + plane.speed);
				
				}
				if(plane.speed >= 300)
				{
					airport.piste.release();
					}

			}
		};
		timer.scheduleAtFixedRate(task, 0 , 100);

	}

	public void takeOfTask() {

	}
}
