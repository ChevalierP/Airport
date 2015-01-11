package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import data.Hour;
import data.Reader;

public class ReaderTests {

	
	
	@Test
	public void test() {
		
		Reader r = new Reader();
		ArrayList<String> testArray = r.readFile("input.csv", ";");
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

		assertEquals(expectedArray, testArray);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void hourInMS() {
		
		Hour h = new Hour();
		int hourInMS = h.getHourInMS("00:10:05");
		String[] expected = new String[3];
		expected[0] = "00";
		expected[1] = "10";
		expected[2] = "05";
		
		assertEquals( 605000 , hourInMS);
		assertEquals( h.tokens , expected);
		
		}

}
