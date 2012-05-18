package com.playtech;

/**
 * Worst performance: 		O(n^2)
 * Average performance: 	O(n log n)
 * Best performance: 		O(n log n)
 * Worst space complexity: 	O(log n)
 */
public class InPlaceQuickSort extends AbstractSortAlgorithm {

	public InPlaceQuickSort() {}

	@Override
	public int[] sort(int[] a) {
		inPlaceQuickSort(a, 0, a.length - 1);
		return a;
	}
	
	private void inPlaceQuickSort(int[] a, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex) {
			// Choose pivot index at middle
			int pivotIndex = leftIndex + (rightIndex - leftIndex) / 2;

			// Get lists of bigger and smaller items and final position of pivot
			int pivotNewIndex = partition(a, leftIndex, rightIndex, pivotIndex);

			// Recursively sort elements smaller than the pivot
			inPlaceQuickSort(a, leftIndex, pivotNewIndex - 1);

			// Recursively sort elements at least as big as the pivot
			inPlaceQuickSort(a, pivotNewIndex + 1, rightIndex);
		}
	}
	
	private int partition(int[] array, int leftIndex, int rightIndex, int pivotIndex) {
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
	
}
