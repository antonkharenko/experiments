import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int[] a = { 12, 7, 25, 3, 6, 58, 2, 10, 1, 5, 1, 7 };
		System.out.println("Array before: " + Arrays.toString(a));
		quickSort(a, 0, a.length - 1);
		System.out.println("Array after: " + Arrays.toString(a));
	}

	public static void quickSort(int[] array, int leftIndex, int rightIndex) {
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
	
	public static int partition(int[] array, int leftIndex, int rightIndex, int pivotIndex) {
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
	
	public static void swap(int[] array, int fromIndex, int toIndex) {
		int tmp = array[fromIndex];
		array[fromIndex] = array[toIndex];
		array[toIndex] = tmp;
	}
	      
	      
}
