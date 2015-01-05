package airport;

import threads.Plane;

public class APP extends Airport {

	public APP(double xPos, double yPos) {

		this.xPos = xPos;
		this.yPos = yPos;
	}

	/*
	 * create planes thread
	 */
	public void create() {
		// TODO Auto-generated method stub
		for (int i = 0; i < list.size() - 2; i += 3) {

			String flightName = (String) list.get(i); // get the flight name on
														// each line in
														// input.csv
			String targetName = (String) list.get(i + 1); // get the target name
															// on each line in
															// input.csv
			String timeOfDeparture = (String) list.get(i + 2); // get the time
																// of departure
																// on each line
																// in input.csv

			Thread plane = new Plane(xPos, yPos, flightName, targetName,
					timeOfDeparture);
			plane.start();
		}
	}

	@Override
	public void writeFile() {
		// TODO Auto-generated method stub

	}
}
