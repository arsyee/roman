package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Roman.*;

public class RomanTest {

	@Test
	public void test() {
		assertEquals("I", Roman.intToRoman(1));
		assertEquals("V", Roman.intToRoman(5));
		assertEquals("X", Roman.intToRoman(10));
		assertEquals("L", Roman.intToRoman(50));
		assertEquals("C", Roman.intToRoman(100));
		assertEquals("D", Roman.intToRoman(500));
		assertEquals("M", Roman.intToRoman(1000));
	}

}
