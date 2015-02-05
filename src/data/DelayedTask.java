package data;

import java.util.Timer;
import java.util.TimerTask;

import threads.Plane;

public class DelayedTask {

	int delay = 0; // en ms
	Plane plane;
	final Trajectory p = new Trajectory();
	final InOut reader = new InOut();

	public DelayedTask(int delay, Plane plane) {
		this.delay = delay;
		this.plane = plane;

		/* récupère l'angle pour quitter le cercle d'attente n°1 */
		plane.alphaTakeOff = p.getAlpha(plane.xInitialPos, plane.yInitialPos,
				plane.targetData[0], plane.targetData[1]);

	}

	public void dTask() {

		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			public void run() {
				try {
					/* contacter le CCR de destination avant */

					plane.airport.waitingAreaAlt500.acquire(); // si le cercle
																// est complet
																// l'avion ne
																// demandera pas
																// l'accès à la
																// piste
					plane.airport.runway.acquire();
					reader.writeFile(
							plane.flightName + " s'aligne sur la piste à "
									+ plane.h.msToFullHour(plane.time) + "\n",
							"Output" + plane.xInitialPos);

					updateTask(); /* prie de vitesse sur la piste */
					takeOffTask(); /*
									 * prise d'altitude une fois en bout de
									 * piste
									 */

				} catch (InterruptedException e) {
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
					plane.xCurrentPos += p.xposTakeOffupdate();
					plane.speed += p.speedTakeOffupdate();
				}
			}
		};
		timer.scheduleAtFixedRate(task, 0, 10);
	}

	public void takeOffTask() {

		final Timer timer = new Timer();

		timer.schedule(new TimerTask() {
			int i = 0;
			int j = 0;
			public void run() {
				plane.airport.runway.release(); /* libère l'accès à la piste */
				TimerTask task = new TimerTask() {
					public void run() { /*
										 * fait monter l'avion à l'altitude du
										 * premier cercle d'attente
										 */
						if (plane.zCurrentPos < 0.5) {
							plane.zCurrentPos += p.zposWaitingArea1();
						} else {
							if (i == 0) {
								/* on log l'arrivée de l'avion sur le 1er cercle */
								reader.writeFile(
										plane.flightName
												+ " arrive sur le premier cercle d'attente à "
												+ plane.h.msToFullHour(plane.time)
												+ "\n", "Output"
												+ plane.xInitialPos);
							}
							i = 1;
							if (plane.theta <= plane.alphaTakeOff) {
								plane.theta += p.setTheta();
								System.out.println("[" + plane.flightName
										+ "] : " + plane.theta);
							} else {
								if (j == 0) {
									plane.airport.waitingAreaAlt500.release();
									reader.writeFile(
											plane.flightName
													+ " quitte le premier cercle d'attente à "
													+ plane.h.msToFullHour(plane.time)
													+ " avec un angle de : "
													+ plane.theta*(180/Math.PI) + "degrés",
											"Output" + plane.xInitialPos);
								}
								j = 1;
							}

						}

					}
				};
				timer.scheduleAtFixedRate(task, 0, 10);
			}
		}, 4800);
	}

	public void time() {
		/* horloge de l'avion créée dès l'initialisation du thread */
		Timer timer = new Timer();

		TimerTask task = new TimerTask() {
			public void run() {

				plane.time += 100;
			}
		};
		timer.scheduleAtFixedRate(task, 0, 1);
	}
}