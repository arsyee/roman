package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Roman.*;

public class RomanTest {

	@Test
	public void test() {
		assertEquals(4, Roman.getDouble(2));
	}

}
