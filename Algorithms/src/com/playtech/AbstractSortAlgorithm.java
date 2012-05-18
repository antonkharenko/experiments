package com.playtech;

/**
 * Class with helper methods common for several sorting algorithms. 
 */
public abstract class AbstractSortAlgorithm implements SortAlgorithm {
	
	protected void swap(int[] a, int fromIndex, int toIndex) {
		int tmp = a[fromIndex];
		a[fromIndex] = a[toIndex];
		a[toIndex] = tmp;
	}
	
}
