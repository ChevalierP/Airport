import airport.APP;
import airport.Airport;
import airport.CCR;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//614.2, -190.1 Ajaccio
		// creation de l'aeroport (CCR + APP)
		Airport CCR = new CCR(Double.parseDouble(args[0]), Double.parseDouble(args[1]));
		Airport APP = new APP(Double.parseDouble(args[0]), Double.parseDouble(args[1]), CCR);

		System.out.println(Double.parseDouble(args[0]));
		System.out.println(Double.parseDouble(args[1]) + "\n");
		APP.readFile(); // lecture du fichier d'entree -> differents
								// vols
		CCR.create(); // creation serveur TCP du CCR
		APP.create(); // creation des threads avion
		
	}

}
