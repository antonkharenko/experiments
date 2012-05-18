package com.playtech;

public class MergeAndSort {

	private SortAlgorithm sortAlgorithm;
	
	public MergeAndSort() {
		this(null);
	}
	
	public MergeAndSort(SortAlgorithm sortAlgorithm) {
		this.sortAlgorithm = sortAlgorithm;
	}
	
	public SortAlgorithm getSortAlgorithm() {
		return sortAlgorithm;
	}

	public void setSortAlgorithm(SortAlgorithm sortAlgorithm) {
		this.sortAlgorithm = sortAlgorithm;
	}

	public void mergeAndSort(int[] a, int[] b, int NaN) {
		merge(a, b, NaN);
		sortAlgorithm.sort(a);
	}
	
	public void merge(int[] a, int[] b, int NaN) {
		int N = a.length;
		int aIndex = 0;
		int bIndex = 0;
		while (aIndex < N && bIndex < N) {
			if (a[aIndex] != NaN) {
				aIndex++;
			} else if (b[bIndex] == NaN) {
				bIndex++;
			} else {
				a[aIndex] = b[bIndex];
				aIndex++;
				bIndex++;
			}
		}
	}
}
