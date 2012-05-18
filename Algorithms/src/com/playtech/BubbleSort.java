package com.playtech;

/**
 * Worst performance: 		O(n^2)
 * Average performance: 	O(n^2)
 * Best performance: 		O(n)
 * Worst space complexity: 	O(1)
 */
public class BubbleSort extends AbstractSortAlgorithm {

	@Override
	public int[] sort(int[] a) {
		bubbleSort(a);
		return a;
	}
	
	private void bubbleSort(int[] a) {
	   boolean swapped;
	   do {
		   swapped = false;
		   for (int i = 1; i < a.length; i++) {
			   if (a[i - 1] > a[i]) {
				   swap(a, i - 1, i);
				   swapped = true;
			   }
		   }
	   } while (swapped);
	}

}
