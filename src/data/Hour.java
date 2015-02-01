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
	
	public String msToFullHour(int msTime)
	{
		int h, min, sec;
		h = (int) msTime/(1000*60*60);
		min = (int) (msTime - 3600*1000*h)/(1000*60);
		sec = (int) (msTime - 3600*1000*h - 1000*60*min)/(1000);
		
		String hS = (h>=10) ? String.valueOf(h) : "0" + String.valueOf(h);
		String minS = (min>=10) ? String.valueOf(min) : "0" + String.valueOf(min);
		String secS = (sec>=10) ? String.valueOf(sec) : "0" + String.valueOf(sec);

		return hS + ":" + minS + ":" + secS;
	}
}
