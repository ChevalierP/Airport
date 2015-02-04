package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import data.Hour;
import data.Reader;

public class ReaderTests {

	@Test
	public void testReadFile() {
		// lecture du fichier d'input de test
		Reader r = new Reader();
		ArrayList<String> testArray = r.readFile("input.csv", ";");

		// construction du tableau attendu
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

		// comparaison du tableau obtenu avec celui attendu
		assertEquals(expectedArray, testArray);
	}
	
	@Test
	public void testReadAirportsFile() {
		
		Reader r = new Reader();
		
		int[] targetData = new int[3];
		int[] expectedArray = new int[3];
		
		targetData = r.findAirportSocket("Toulouse");
		expectedArray[0] = Integer.valueOf(0); expectedArray[1] = Integer.valueOf(0); expectedArray[2] = Integer.valueOf(2210);
		
		System.out.println(targetData[0]);
		System.out.println(targetData[1]);
		System.out.println(targetData[2]);

		
		assertEquals(expectedArray, targetData);
		/*
		targetData = r.findAirportSocket("Paris CdG");
		expectedArray[0] = 95; expectedArray[1] = 615; expectedArray[2] = 2211;
		
		assertEquals(targetData,expectedArray);
		
		targetData = r.findAirportSocket("Nice");
		expectedArray[0] = 470; expectedArray[1] = 3; expectedArray[2] = 2212;
		
		assertEquals(targetData,expectedArray);
		
		targetData = r.findAirportSocket("Bale");
		expectedArray[0] = 496; expectedArray[1] = 441; expectedArray[2] = 2213;
		
		assertEquals(targetData,expectedArray);
		
		targetData = r.findAirportSocket("Lyon");
		expectedArray[0] = 299; expectedArray[1] = 233; expectedArray[2] = 2214;
		
		assertEquals(targetData,expectedArray);
		
		targetData = r.findAirportSocket("Strasbourg");
		expectedArray[0] = 504; expectedArray[1] = 547; expectedArray[2] = 2215;
		
		assertEquals(targetData,expectedArray);
		
		targetData = r.findAirportSocket("Metz");
		expectedArray[0] = 393; expectedArray[1] = 595; expectedArray[2] = 2216;
		
		assertEquals(targetData,expectedArray);
		*/
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

		assertEquals(605000, hourInMS); // on vérifie que la conversion est
										// correcte
		assertEquals(h.tokens, expected); // on véfifie que chaque élément du
											// tableau est le bon

	}

	@Test
	public void testHour() {

		Hour h = new Hour();
		int hourInMS = 2*1000*3600 /* 2 h en ms*/ + 11 *1000*60 /* 11min en ms*/ + 50*1000 /* 50s en ms*/;
		String s = h.msToFullHour(hourInMS);

		assertEquals(s, "02:11:50"); // on vérifie que la conversion est correcte
		

	}
}
