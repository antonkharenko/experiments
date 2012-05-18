package com.playtech;

import org.junit.Assert;
import org.junit.Test;

public class MergeAndSortTest {
	
	@Test
	public void testMerge() {
		// Given
		final int NaN = -1;
		int[] a = { 23, NaN, 47, 21, 81, 95, NaN, 37, NaN, NaN };
		int[] b = { NaN, NaN, NaN, 7, NaN, NaN, 37, 55, NaN, 62 };
		MergeAndSort mergeAndSort = new MergeAndSort(); 

		// When
		mergeAndSort.merge(a, b, NaN);
		
		// Then
		int[] expected = {23, 7, 47, 21, 81, 95, 37, 37, 55, 62};
		Assert.assertArrayEquals(expected, a);
	}
	
	@Test
	public void testMergeAndSort() {
		// Given
		final int NaN = -1;
		int[] a = { 23, NaN, 47, 21, 81, 95, NaN, 37, NaN, NaN };
		int[] b = { NaN, NaN, NaN, 7, NaN, NaN, 37, 55, NaN, 62 };
		SortAlgorithm sortAlgorithm = new InPlaceQuickSort();
		MergeAndSort mergeAndSort = new MergeAndSort(sortAlgorithm);
		
		// When
		mergeAndSort.mergeAndSort(a, b, NaN);
		
		// Then
		int[] expected = {7, 21, 23, 37, 37, 47, 55, 62, 81, 95};
		Assert.assertArrayEquals(expected, a);
	}
}
