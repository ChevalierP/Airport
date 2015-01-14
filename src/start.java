import airport.APP;
import airport.Airport;
import airport.CCR;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//614.2, -190.1 Ajaccio
		// creation de l'aeroport (CCR + APP)
		Airport Ajaccio_CCR = new CCR(Double.parseDouble(args[0]), Double.parseDouble(args[1]));
		Airport Ajaccio_APP = new APP(Double.parseDouble(args[0]), Double.parseDouble(args[1]));

		System.out.println(Double.parseDouble(args[0]));
		System.out.println(Double.parseDouble(args[1]) + "\n");
		Ajaccio_APP.readFile(); // lecture du fichier d'entree -> differents
								// vols
		Ajaccio_CCR.create(); // creation serveur TCP du CCR
		Ajaccio_APP.create(); // creation des threads avion
		
	}

}
