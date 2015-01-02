import java.util.ArrayList;

public class APP_Ajaccio {

	@SuppressWarnings("rawtypes")
	ArrayList list;

	public APP_Ajaccio() {

	}

	public void getInputData() {

		Reader r = new Reader();

		ArrayList<String> inputData = new ArrayList<String>();
		inputData = r.readFile("input.csv");

		this.list = inputData;
	}

	public void sendData(Ajaccio_airport airport) {
		for (int i = 0; i < list.size() - 2; i += 3) {
			
			String flightName = (String)list.get(i);
			String targetName = (String)list.get(i + 1);
			String timeOfDeparture = (String)list.get(i + 2);
			
			Thread plane = new Plane(airport.getXpos(), airport.getYpos(),
					flightName, targetName, timeOfDeparture);
			plane.start();
		}
	}
}
