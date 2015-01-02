public class CCR_Ajaccio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Ajaccio_airport airport = new Ajaccio_airport();
		APP_Ajaccio app = new APP_Ajaccio();
		app.getInputData();

		app.sendData(airport);
	}

}
