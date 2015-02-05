package airport;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

import data.InOut;

public abstract class Airport {

	// xpos = 614.2; // Ajaccio airport
	// ypos = -190.1;

	ArrayList<String> list;

	protected double xPos = 0;
	protected double yPos = 0;

	public Semaphore runway = new Semaphore(1);
	public Semaphore parking = new Semaphore(30);

	public Semaphore waitingAreaAlt500 = new Semaphore(5);
	public Semaphore waitingAreaAlt1000 = new Semaphore(5);
	public Semaphore waitingAreaAlt1500 = new Semaphore(5);
	public Semaphore waitingAreaAlt2000 = new Semaphore(5);

	public String name;
	
	
	public abstract void create();

	public void readFile() {
		InOut r = new InOut();

		ArrayList<String> inputData = new ArrayList<String>();
		inputData = r.readFile("input.csv", ";");

		this.list = inputData;
	}
}
