package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Roman.*;

public class RomanTest {

	@Test
	public void testZero() {
		assertEquals("", Roman.intToRoman(0));
	}
	
	@Test
	public void testSingle() {
		assertEquals("I", Roman.intToRoman(1));
		assertEquals("V", Roman.intToRoman(5));
		assertEquals("X", Roman.intToRoman(10));
		assertEquals("L", Roman.intToRoman(50));
		assertEquals("C", Roman.intToRoman(100));
		assertEquals("D", Roman.intToRoman(500));
		assertEquals("M", Roman.intToRoman(1000));
	}

	@Test
	public void testAddition() {
		assertEquals("II", Roman.intToRoman(2));
		assertEquals("III", Roman.intToRoman(3));
		
		assertEquals("VI", Roman.intToRoman(6));
		assertEquals("VII", Roman.intToRoman(7));
		assertEquals("VIII", Roman.intToRoman(8));

		assertEquals("XII", Roman.intToRoman(12));
		assertEquals("LI", Roman.intToRoman(51));
		assertEquals("MIII", Roman.intToRoman(1003));
	}
	
	@Test
	public void test99() {
		// assertEquals("XCIX", Roman.intToRoman(99)); // apparently this is how to convert, check rules again!
	}
	
	@Test
	public void testAll() {
		fail(); // write a test, which iterates over all the possibilities and checks if the result is the same after double-conversion
	}
	
	@Test
	public void testErrorHandling() {
		fail(); // please implement error handling (i.e. create tests with erroneous data), examples:
				// * negative numbers
				// * higher than MAX value
				// * wrong order in roman numbers, i.e. IC, IIX, etc.
				// * two many characters in roman numbers, like MMMM or VV
				// * unknown character in roman numbers, like CXXXSI
				// * anything else you might think of
	}
}
