import java.util.concurrent.Semaphore;

public class Ajaccio_airport {

	// position relative de l'aeroport d'Ajaccio par rapport à celui de Toulouse
	// Blagnac

	private double xpos = 614.2;

	private double ypos = -190.1;

	Semaphore parking, piste, waitingAreaAlt500, waitingAreaAlt1000,
			waitingAreaAlt1500, waitingAreaAlt2000;

	public Ajaccio_airport() {
		parking = new Semaphore(30);
		piste = new Semaphore(1);
		waitingAreaAlt500 = new Semaphore(5);
		waitingAreaAlt1000 = new Semaphore(5);
		waitingAreaAlt1500 = new Semaphore(5);
		waitingAreaAlt2000 = new Semaphore(5);
	}

	public double getXpos() {
		return xpos;

	}

	public double getYpos() {
		return ypos;

	}
}
