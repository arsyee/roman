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
}
