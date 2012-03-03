package com.amazon;

public class Excercise {
	
	/**
	 * Finds the sum of the most common integer in the given array.
	 * 
	 * Example:  (2,4,5,6,4) – return 8 (as 4+4 = 8)
	 * (1,2,1,3,1) – return 3 (as 1+1+1 = 3)
	 * 
	 * @param array given array of integers
	 * @return Sum of the most common integer in the given array. Returned 
	 * value is long to support cases when sum is out of integer range.  
	 * @throws IllegalArgumentException if the given array is null or empty or 
	 * if the given array doesn't contains most common integer (this case isn't
	 * defined in the task) 
	 */
	public long getMostCommonIntegerSum(int[] array) {
		if (array == null) {
			throw new IllegalArgumentException("Array can't be null");
		}
		if (array.length == 0) {
			throw new IllegalArgumentException("Array can't be empty");
		}
		long mostCommonValue = 0;
		int mostCommonCount = 0;
		boolean unique = true;
		int currentCount;
		for (int currentIndex = 0; currentIndex < array.length; currentIndex++) {
			currentCount = 0;
			for (int compareIndex = 0; compareIndex < array.length; compareIndex++) {
				if (array[currentIndex] == array[compareIndex]) {
					currentCount++;
				}
			}
			if (currentCount > mostCommonCount) {
				mostCommonCount = currentCount;
				mostCommonValue = array[currentIndex];
				unique = true;
			} else if (currentCount == mostCommonCount && mostCommonValue != array[currentIndex]) {
				unique = false;
			}
		}
		if (unique) {
			return mostCommonCount * mostCommonValue;
		} else {
			throw new IllegalArgumentException("Given array doesn't contains most common integer");
		}
	}
}
