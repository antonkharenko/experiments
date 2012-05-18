package com.playtech;

/**
 * Worst performance: O(n log n) Average performance: O(n log n) Best
 * performance: O(n log n) Worst space complexity: O(1)
 */
public class HeapSort extends AbstractSortAlgorithm {

	@Override
	public int[] sort(int[] a) {
		heapSort(a);
		return a;
	}

	private void heapSort(int[] a) {
		buildHeap(a);
		int end = a.length - 1;
		while (end > 0) {
			// Swap the root(maximum value) of the heap with the last element of
			// the heap
			swap(a, 0, end);

			// Decrease the size of the heap by one so that the previous max
			// value will stay in its proper placement
			end--;

			// Put the heap back in max-heap order
			siftDown(a, 0, end);
		}
	}

	private void buildHeap(int[] a) {
		// start is assigned the index in a of the last parent node
		int start = a.length / 2 - 1;

		while (start >= 0) {
			// sift down the node at index start to the proper place such that
			// all nodes below the start index are in heap order
			// after sifting down the root all nodes/elements are in heap order
			siftDown(a, start, a.length - 1);
			start--;
		}
	}

	private void siftDown(int[] a, int start, int end) {
		int root = start;
		int child;
		int swap;

		// While the root has at least one child
		while ((root * 2 + 1) <= end) {
			// root*2 + 1 points to the left child
			child = root * 2 + 1;

			// keeps track of child to swap with
			swap = root;

			// check if root is smaller than left child
			if (a[swap] < a[child]) {
				swap = child;
			}

			// check if right child exists, and if it's bigger than what we're
			// currently swapping with
			if ((child + 1 <= end) && a[swap] < a[child + 1]) {
				swap = child + 1;
			}

			// check if we need to swap at all)
			if (swap != root) {
				swap(a, root, swap);
				root = swap; // repeat to continue sifting down the child now
			} else {
				return;
			}

		}
	}

}
