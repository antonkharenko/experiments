package com.playtech;

public class QuickSort {

	public static void sort(int[] array) {
		quickSort(array, 0, array.length - 1);
	}
	
	private static void quickSort(int[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex) {
			// Choose pivot index at middle
			int pivotIndex = leftIndex + (rightIndex - leftIndex) / 2;

			// Get lists of bigger and smaller items and final position of pivot
			int pivotNewIndex = partition(array, leftIndex, rightIndex, pivotIndex);

			// Recursively sort elements smaller than the pivot
			quickSort(array, leftIndex, pivotNewIndex - 1);

			// Recursively sort elements at least as big as the pivot
			quickSort(array, pivotNewIndex + 1, rightIndex);
		}
	}
	
	private static int partition(int[] array, int leftIndex, int rightIndex, int pivotIndex) {
		int pivotValue = array[pivotIndex];
		swap(array, pivotIndex, rightIndex);  // Move pivot to end
		int newPivotIndex = leftIndex;
		for (int currentIndex = leftIndex; currentIndex < rightIndex; currentIndex++) {
			if (array[currentIndex] < pivotValue) {
				swap(array, currentIndex, newPivotIndex);
				newPivotIndex = newPivotIndex + 1;
			}
		}
		swap(array, newPivotIndex, rightIndex);  // Move pivot to its final place
		return newPivotIndex;
		
	}
	
	private static void swap(int[] array, int fromIndex, int toIndex) {
		int tmp = array[fromIndex];
		array[fromIndex] = array[toIndex];
		array[toIndex] = tmp;
	}
}
