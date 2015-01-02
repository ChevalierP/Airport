package airport;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

import plane.Plane;
import data.Reader;

public class APP_Ajaccio {

	@SuppressWarnings("rawtypes")
	ArrayList list;
	Ajaccio_airport airport;
	Semaphore piste = new Semaphore(1);
	Semaphore parking = new Semaphore(30);

	public APP_Ajaccio() {
		airport = new Ajaccio_airport();
	}

	public void getInputData() {

		Reader r = new Reader();

		ArrayList<String> inputData = new ArrayList<String>();
		inputData = r.readFile("input.csv");

		this.list = inputData;
	}

	public void sendData() {
		for (int i = 0; i < list.size() - 2; i += 3) {

			String flightName = (String) list.get(i);
			String targetName = (String) list.get(i + 1);
			String timeOfDeparture = (String) list.get(i + 2);

			Thread plane = new Plane(airport.getXpos(), airport.getYpos(),
					flightName, targetName, timeOfDeparture);
			plane.start();
		}
	}
}
