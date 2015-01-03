package threads;

import java.io.IOException;

import transmission.Serveur;
import transmission.Transmission;

public class CommunicationThreads extends Thread {

	int portNumber;

	public CommunicationThreads(int portNumber) {

		this.portNumber = portNumber;
	}

	public void run() {

		System.out.println("thread lancé");
		Transmission CCRServeur = new Serveur(this.portNumber);
		try {
			CCRServeur.create();
			System.out.println("création de serveur demandée");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
