package com.playtech;

import org.junit.Assert;
import org.junit.Test;

public class SortAlgorithmsTest {
	
	@Test
	public void testInPlaceQuickSort() {
		// Given
		int[] a = { 12, 7, 25, 3, 6, 58, 2, 10, 1, 5, 1, 7 };
		SortAlgorithm sortAlgorithm = new InPlaceQuickSort();
		
		// When
		sortAlgorithm.sort(a);
		
		// Then
		int[] expected = {1, 1, 2, 3, 5, 6, 7, 7, 10, 12, 25, 58};
		Assert.assertArrayEquals(expected, a);
	}
	
	@Test
	public void testBubbleSort() {
		// Given
		int[] a = { 12, 7, 25, 3, 6, 58, 2, 10, 1, 5, 1, 7 };
		SortAlgorithm sortAlgorithm = new BubbleSort();
		
		// When
		sortAlgorithm.sort(a);
		
		// Then
		int[] expected = {1, 1, 2, 3, 5, 6, 7, 7, 10, 12, 25, 58};
		Assert.assertArrayEquals(expected, a);
	}
	
	@Test
	public void testHeapsort() {
		// Given
		int[] a = { 12, 7, 25, 3, 6, 58, 2, 10, 1, 5, 1, 7 };
		SortAlgorithm sortAlgorithm = new HeapSort();
		
		// When
		sortAlgorithm.sort(a);
		
		// Then
		int[] expected = {1, 1, 2, 3, 5, 6, 7, 7, 10, 12, 25, 58};
		Assert.assertArrayEquals(expected, a);
	}
	
}
