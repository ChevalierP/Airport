package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader {

	FileInputStream fis;

	public Reader() {
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
					champ = champ.replaceAll("(\\r|\\n|\\t)", "");// pour supprimer les \r\n du fichier lu
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

}
