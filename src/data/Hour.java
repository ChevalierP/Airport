package data;

public class Hour {

	int hourInMS = 0;
	public String[] tokens;

	public Hour() {
	}

	public int getHourInMS(String timeOfDeparture) {
		String delims = ":";
		this.tokens = timeOfDeparture.split(delims);

		hourInMS = 3600000 * Integer.parseInt(tokens[0]) + 60000
				* Integer.parseInt(tokens[1]) + 1000
				* Integer.parseInt(tokens[2]);

		return this.hourInMS;

	}
}
