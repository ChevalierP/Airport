package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader {

	FileInputStream fis;

	public Reader() {
	}

	public ArrayList<String> readFile(String name, String delimiter) {

		ArrayList<String> inputData = new ArrayList<String>();
		try {
			// cr�ation de la ressource
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

			} finally { // lib�ration de la ressource
				s.close();
			}

		} catch (FileNotFoundException e1) {
			System.out.println("Le fichier indiqu� n'existe pas.");
		}

		return inputData;
	}

	
	public void writeFile(String text, String fileName)
	{
		try {
			FileWriter writer = new FileWriter(fileName + ".doc", true);	
			
				writer.write(text);
				writer.write("\n");
				writer.close(); //lib�ration de la ressource
			
		} catch (IOException e) {
			System.out.println("impossible de cr�er le fichier");
		} 
		
	}
}
