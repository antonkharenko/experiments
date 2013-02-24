package org.coursera.algorithms.week1;

import java.util.Arrays;

public class MyWeightedQuickUnionUF {
	
	private int[] id;
	private int[] sz;
	
	public MyWeightedQuickUnionUF(int n) {
		id = new int[n];
		sz = new int[n];
		for (int i = 0; i < n; i++) {
			id[i] = i;
			sz[i] = 1;
		}
	}
	
	private int root(int i) {
		while (i != id[i]) {
			i = id[i];
		}
		return i;
	}
	
	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}
	
	public void union(int p, int q) {
		int i = root(p);
		int j = root(q);
		if (sz[i] < sz[j]) {
			id[i] = j;
			sz[j] += sz[i];
		} else {
			id[j] = i;
			sz[i] += sz[j];
		}
	}

	@Override
	public String toString() {
		return "id = " + Arrays.toString(id) + " sz = " + Arrays.toString(sz);
	}
	
	public static void main(String arg[]) {
		int n = 10;
		MyWeightedQuickUnionUF uf = new MyWeightedQuickUnionUF(n);
		//4-7 0-7 2-3 0-8 6-9 2-6 7-9 7-1 5-0
		int[][] unions = {
				{4, 7}, 
				{0, 7}, 
				{2, 3}, 
				{0, 8}, 
				{6, 9}, 
				{2, 6},
				{7, 9},
				{7, 1},
				{5, 0}
		};
		
		for (int unionIndex = 0; unionIndex < unions.length; unionIndex++) {
			uf.union(unions[unionIndex][0], unions[unionIndex][1]);
			System.out.println(unions[unionIndex][0] + "-" + unions[unionIndex][1] + " => " + uf);
		}
	}
	
}
