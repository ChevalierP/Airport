package airport;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

import data.Reader;

public abstract class Airport {

	// xpos = 614.2; // Ajaccio airport
	// ypos = -190.1;

	ArrayList<String> list;

	protected double xPos = 0;
	protected double yPos = 0;

	Semaphore piste = new Semaphore(1);
	Semaphore parking = new Semaphore(30);

	Semaphore waitingAreaAlt500 = new Semaphore(5);;
	Semaphore waitingAreaAlt1000 = new Semaphore(5);;
	Semaphore waitingAreaAlt1500 = new Semaphore(5);;
	Semaphore waitingAreaAlt2000 = new Semaphore(5);;

	public abstract void create();

	public void readFile() {
		Reader r = new Reader();

		ArrayList<String> inputData = new ArrayList<String>();
		inputData = r.readFile("input.csv");

		this.list = inputData;
	}

	abstract void writeFile();
}
