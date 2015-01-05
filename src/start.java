import airport.APP;
import airport.Airport;
import airport.CCR;

public class start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// creation de l'aeroport (CCR + APP)
		Airport Ajaccio_CCR = new CCR(614.2, -190.1);
		Airport Ajaccio_APP = new APP(614.2, -190.1);

		Ajaccio_APP.readFile(); // lecture du fichier d'entree -> differents
								// vols
		Ajaccio_CCR.create(); // creation serveur TCP du CCR
		Ajaccio_APP.create(); // creation des threads avion
	}

}
