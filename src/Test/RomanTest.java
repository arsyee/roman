package Test;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.rules.*;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;

import Roman.*;
import Roman.Roman.Exception;


public class RomanTest {

	@Test
	public void testZero() {
		try {
			assertEquals("", Roman.intToRoman(0));
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void testSingle() {
		try {
			assertEquals("I", Roman.intToRoman(1));
			assertEquals("V", Roman.intToRoman(5));
			assertEquals("X", Roman.intToRoman(10));
			assertEquals("L", Roman.intToRoman(50));
			assertEquals("C", Roman.intToRoman(100));
			assertEquals("D", Roman.intToRoman(500));
			assertEquals("M", Roman.intToRoman(1000));
		} catch (Exception e) {
			fail();
		}
		
	}

	@Test
	public void testAddition() {
		try {
			assertEquals("II", Roman.intToRoman(2));
			assertEquals("III", Roman.intToRoman(3));
		
			assertEquals("VI", Roman.intToRoman(6));
			assertEquals("VII", Roman.intToRoman(7));
			assertEquals("VIII", Roman.intToRoman(8));

			assertEquals("XII", Roman.intToRoman(12));
			assertEquals("LI", Roman.intToRoman(51));
			assertEquals("MIII", Roman.intToRoman(1003));
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void testOthers() {
		try {
			assertEquals("XXII", Roman.intToRoman(22));
			assertEquals("LXIII", Roman.intToRoman(63));
			assertEquals("LXVI", Roman.intToRoman(66));
			assertEquals("CXVII", Roman.intToRoman(117));
			assertEquals("XCIX", Roman.intToRoman(99));
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void testRomanZero() {
		try {
			assertEquals(0, Roman.romanToInt(""));
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void testRomanSingle() {
		try {
			assertEquals(1, Roman.romanToInt(Roman.intToRoman(1)));
			assertEquals(5, Roman.romanToInt(Roman.intToRoman(5)));
			assertEquals(10, Roman.romanToInt(Roman.intToRoman(10)));
			assertEquals(50, Roman.romanToInt(Roman.intToRoman(50)));
			assertEquals(100, Roman.romanToInt(Roman.intToRoman(100)));
			assertEquals(500, Roman.romanToInt(Roman.intToRoman(500)));
			assertEquals(1000, Roman.romanToInt(Roman.intToRoman(1000)));
		} catch (Exception e) {
			fail();
		}
		
	}
	
	@Test
	public void testRomanEasy() {
		try {
			assertEquals(12, Roman.romanToInt(Roman.intToRoman(12)));
			assertEquals(63, Roman.romanToInt(Roman.intToRoman(63)));
			assertEquals(11, Roman.romanToInt(Roman.intToRoman(11)));
			assertEquals(58, Roman.romanToInt(Roman.intToRoman(58)));
			assertEquals(136, Roman.romanToInt(Roman.intToRoman(136)));
			assertEquals(815, Roman.romanToInt(Roman.intToRoman(815)));
			assertEquals(2372, Roman.romanToInt(Roman.intToRoman(2372)));
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void testRomanHard() {
		try {
			assertEquals(4, Roman.romanToInt(Roman.intToRoman(4)));
			assertEquals(9, Roman.romanToInt(Roman.intToRoman(9)));
			assertEquals(14, Roman.romanToInt(Roman.intToRoman(14)));
			assertEquals(45, Roman.romanToInt(Roman.intToRoman(45)));
			assertEquals(99, Roman.romanToInt(Roman.intToRoman(99)));
			assertEquals(459, Roman.romanToInt(Roman.intToRoman(459)));
			assertEquals(2009, Roman.romanToInt(Roman.intToRoman(2009)));
			assertEquals(3899, Roman.romanToInt(Roman.intToRoman(3899)));
		} catch (Exception e) {
			System.out.println(e.toString());
			fail();
		}
	}
	
	@Test
	public void testRomanAll() {
		for (int i=0; i<4000; i++) {
			try {
				assertEquals(i, Roman.romanToInt(Roman.intToRoman(i)));
			} catch (Exception e) {
				fail();
			}
		}
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testNegative() throws Exception {
		thrown.expect(Roman.Exception.class);
		thrown.expectMessage(is("Negative number"));
		Roman.intToRoman(-1);
	}
	
	@Test
	public void testHigherThanMax() throws Exception {
		thrown.expect(Roman.Exception.class);
		thrown.expectMessage(is("Higher than maximum value"));
		Roman.intToRoman(4000);
			
	}
	
	@Test
	public void testUnknown() throws Exception {
		thrown.expect(Roman.Exception.class);
		thrown.expectMessage(is("Unknown character: B"));
		Roman.romanToInt("CXB");
		
	}
	
	@Test
	public void testMultipleM() throws Exception {
		thrown.expect(Roman.Exception.class);
		thrown.expectMessage(is("Too many characters: M"));
		Roman.romanToInt("MMMM");
	}
	
	@Test
	public void testMultipleC() throws Exception {
		thrown.expect(Roman.Exception.class);
		thrown.expectMessage(is("Too many characters: C"));
		Roman.romanToInt("MCCCCCIV");
	}
	
	@Test
	public void testMultipleV() throws Exception {
		thrown.expect(Roman.Exception.class);
		thrown.expectMessage(is("Too many characters: V"));
		Roman.romanToInt("XVVVI");
	}
	
	@Test
	public void testMultipleSubstract() throws Exception {
		thrown.expect(Roman.Exception.class);
		thrown.expectMessage(is("Cannot substract multiple times: 1"));
		Roman.romanToInt("XIIV");		
	}

	@Test
	public void testSubstractFails1() throws Exception {
		thrown.expect(Roman.Exception.class);
		thrown.expectMessage(is("Cannot substract 1 from 100"));
		System.out.println("IC is "+Roman.romanToInt("IC"));
	}
	
	@Test
	public void testSubsrtactFails2() throws Exception {
		thrown.expect(Roman.Exception.class);
		thrown.expectMessage(is("Cannot substract 5 from 500"));
		System.out.println("VD is "+Roman.romanToInt("VD"));
	}
	
	@Test
	public void testSubstractFails3() throws Exception {
		thrown.expect(Roman.Exception.class);
		thrown.expectMessage(is("Cannot substract 1 from 500"));
		System.out.println("VID is "+Roman.romanToInt("VID"));
	}
}
