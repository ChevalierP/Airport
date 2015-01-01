import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader {

	FileInputStream fis;

	public Reader() {
	}

	public ArrayList<String> readFile(String name) {

		ArrayList<String> inputData = new ArrayList<String>();
		try {
			// création de la ressource
			fis = new FileInputStream(name);

			Scanner s = new Scanner(fis);

			try {
				// utilisation de la ressource
				s.useDelimiter(";");

				String champ;
				while (s.hasNext()) {
					champ = s.next();
					inputData.add(champ);
				}

			} finally { // libération de la ressource
				s.close();
			}

		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return inputData;
	}

}
