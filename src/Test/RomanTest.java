package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Roman.*;

public class RomanTest {

	@Test
	public void test() {
		assertEquals("I", Roman.intToRoman(1));
		assertEquals("V", Roman.intToRoman(5));
	}

}
