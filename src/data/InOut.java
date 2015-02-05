package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class InOut {

	FileInputStream fis;

	public InOut() {
	}

	public ArrayList<String> readFile(String name, String delimiter) {

		ArrayList<String> inputData = new ArrayList<String>();
		try {
			// création de la ressource
			fis = new FileInputStream(name);

			Scanner s = new Scanner(fis);

			try {
				// utilisation de la ressource
				s.useDelimiter(delimiter);

				String champ;
				while (s.hasNext()) {
					champ = s.next();
					champ = champ.replaceAll("(\\r|\\n|\\t)", "");// pour
																	// supprimer
																	// les \r\n
																	// du
																	// fichier
																	// lu
					inputData.add(champ);
				}

			} finally { // libération de la ressource
				s.close();
			}

		} catch (FileNotFoundException e1) {
			System.out.println("Le fichier indiqué n'existe pas.");
		}

		return inputData;
	}
	
	
	public int[] findAirportSocket(String targetName)
	{
		ArrayList<String> airportsSockets = readFile("Airports.csv", ";");
		
		int[] airportFound = new int[3];
		
		for(int i = 0; i < airportsSockets.size(); i++)
		{
			if(airportsSockets.get(i).equals(targetName) )
			{
				airportFound[0] = Integer.valueOf(airportsSockets.get(i+1));
				airportFound[1] = Integer.valueOf(airportsSockets.get(i+2));
				airportFound[2] = Integer.valueOf(airportsSockets.get(i+3));

			}
		}
		
		return airportFound;
		
	}

	
	public void writeFile(String text, String fileName)
	{
		try {
			FileWriter writer = new FileWriter(fileName + ".doc", true);	
			
				writer.write(text);
				writer.write("\n");
				writer.close(); //libération de la ressource
			
		} catch (IOException e) {
			System.out.println("impossible de créer le fichier");
		} 
		
	}
}
