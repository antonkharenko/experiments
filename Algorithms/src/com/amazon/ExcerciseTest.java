package com.amazon;

import junit.framework.Assert;

import org.junit.Test;

public class ExcerciseTest {
	
	@Test
	public void testMostCommonIntegerSum() {
		Excercise ex = new Excercise();
		int[][] testData = {
				{2,4,5,6,4},
				{1,2,1,3,1},
				{0,0,3,4,5,0,3,4},
				{-1,-5,-1,2,4},
				{1},
				{Integer.MAX_VALUE,3,4,Integer.MAX_VALUE}
			};
		long[] expectedResults = {8, 3, 0, -2, 1, 2L * Integer.MAX_VALUE};
		
		for (int testIndex = 0; testIndex < testData.length; testIndex++) {
			long result = ex.getMostCommonIntegerSum(testData[testIndex]);
			Assert.assertEquals(expectedResults[testIndex], result);
		}
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testMostCommonIntegerSumWithNull() {
		Excercise ex = new Excercise();
		ex.getMostCommonIntegerSum(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testMostCommonIntegerSumWithEmptyArray() {
		Excercise ex = new Excercise();
		ex.getMostCommonIntegerSum(new int[] {});
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testMostCommonIntegerSumWithoutMostCommonInteger() {
		Excercise ex = new Excercise();
		ex.getMostCommonIntegerSum(new int[] {1,2,3,4,5});
	}
}
