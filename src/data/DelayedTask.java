package data;

import java.util.Timer;
import java.util.TimerTask;

import airport.Airport;
import threads.Plane;

public class DelayedTask {

	int delay = 0; // en ms
	String flightName;
	String targetName;
	String timeOfDeparture;
	Airport airport;
	Plane plane;
	final Trajectory p = new Trajectory();
	final Reader reader = new Reader();

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
					reader.writeFile(plane.flightName + " s'aligne sur la piste à " + plane.h.msToFullHour(plane.time) + "\n", "Output" + plane.xInitialPos);

					updateTask();
					takeOffTask();

					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}, delay / 100);
	}

	public void updateTask() {

		Timer timer = new Timer();

		TimerTask task = new TimerTask() {
			public void run() {
				if (plane.speed < 300) {
					plane.xCurrentPos = p.xposTakeOffupdate(plane.xCurrentPos);
					plane.speed = p.speedTakeOffupdate(plane.speed);

					System.out.println("[" + flightName + "]" + " Xpos : "
							+ plane.xCurrentPos);
					System.out.println("[" + flightName + "]" + " Speed : "
							+ plane.speed);

				}
			}
		};
		timer.scheduleAtFixedRate(task, 0, 10);
	}

	public void takeOffTask() {

		final Timer timer = new Timer();
		
		timer.schedule(new TimerTask() {
			 int i = 0;

			public void run() {
				airport.piste.release();
				TimerTask task = new TimerTask() {
					public void run() {
						if (plane.zCurrentPos < 0.5) {
							plane.zCurrentPos = p.zposWaitingArea1(plane.zCurrentPos);
							System.out.println("[" + flightName + "]" +  " Zpos : " + plane.zCurrentPos);
							}
						else
						{
							if(i == 0)
							{
								reader.writeFile(plane.flightName + " arrive sur le premier cercle d'attente à " + plane.h.msToFullHour(plane.time) + "\n", "Output" + plane.xInitialPos);
							}
							i = 1;
							
							plane.xCurrentPos = p.xposWaitingArea(plane.xCurrentPos, plane.theta);
							System.out.println(plane.xCurrentPos);
							plane.yCurrentPos = p.xposWaitingArea(plane.yCurrentPos, plane.theta);
							System.out.println(plane.yCurrentPos);
							plane.theta += 150/3600;

							
						}
						
					}
				};
				timer.scheduleAtFixedRate(task, 0, 10);

			}
		}, 4800);
	}
	
	public void time() {

		Timer timer = new Timer();

		TimerTask task = new TimerTask() {
			public void run() {
				
				plane.time += 100;
				}
			};
		timer.scheduleAtFixedRate(task, 0, 1);
	}
}