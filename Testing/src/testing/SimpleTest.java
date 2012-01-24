package testing;

import junit.framework.Assert;

import org.junit.Test;


public class SimpleTest {
	
	@Test
	public void simpleTest() {
		int result = 2 * 2;
		Assert.assertEquals(4, result);
	}

}
