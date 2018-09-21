package junit.test;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestTest {

	@Test
	public void testAdd() {
		int c = new junit.test.Test().add(2, 5);
		assertEquals(7, c);
	}

	@Test
	public void testDivide() {
		int  c = new junit.test.Test().divide(8, 2);
		System.out.println(c);
	}

}
