import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Reader {

	FileInputStream fis;

	public Reader() {
	}

	public void readFile(String name) {
		try {
			fis = new FileInputStream(name);

			Scanner s = new Scanner(fis);
			s.useDelimiter(";");
			
			String champ;
			while(s.hasNext())
			{
				champ = s.next();
				System.out.println(champ);
			}
			
		} catch (FileNotFoundException e) {

			System.out.println("Fichier inexistant");
		}
	}

}
