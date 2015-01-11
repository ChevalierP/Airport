package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import data.Hour;
import data.Reader;

public class ReaderTests {

	
	
	@Test
	public void testReadFile() {
		//lecture du fichier d'input de test
		Reader r = new Reader();
		ArrayList<String> testArray = r.readFile("input.csv", ";");
		
		//construction du tableau attendu
		ArrayList<String> expectedArray = new ArrayList<String>();
		expectedArray.add("Vol000");
		expectedArray.add("Toulouse");
		expectedArray.add("00:00:00");

		expectedArray.add("Vol001");
		expectedArray.add("Paris CdG");
		expectedArray.add("00:15:00");

		expectedArray.add("Vol002");
		expectedArray.add("Nice");
		expectedArray.add("00:30:00");

		expectedArray.add("Vol003");
		expectedArray.add("Bale");
		expectedArray.add("00:45:00");

		expectedArray.add("Vol004");
		expectedArray.add("Lyon");
		expectedArray.add("01:00:00");

		expectedArray.add("Vol005");
		expectedArray.add("Strasbourg");
		expectedArray.add("01:15:00");

		expectedArray.add("Vol006");
		expectedArray.add("Metz");
		expectedArray.add("01:30:00");
		expectedArray.add("");

		//comparaison du tableau obtenu avec celui attendu
		assertEquals(expectedArray, testArray);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testHourInMS() {
		
		Hour h = new Hour();
		int hourInMS = h.getHourInMS("00:10:05");
		String[] expected = new String[3];
		expected[0] = "00";
		expected[1] = "10";
		expected[2] = "05";
		
		assertEquals( 605000 , hourInMS); // on vérifie que la conversion est correcte
		assertEquals( h.tokens , expected); // on véfifie que chaque élément du tableau est le bon
		
		}

}
