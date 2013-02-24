package org.coursera.algorithms.week1;

import java.util.Arrays;

public class MyQuickUnionUF {
	
	private int[] id;
	
	public MyQuickUnionUF(int n) {
		id = new int[n];
		for (int i = 0; i < n; i++) {
			id[i] = i;
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
		id[i] = j;
	}

	@Override
	public String toString() {
		return "id = " + Arrays.toString(id);
	}
	
	public static void main(String arg[]) {
		int n = 10;
		MyQuickUnionUF uf = new MyQuickUnionUF(n);
		// 0-7 6-8 1-2 5-6 4-2 9-1 
		int[][] unions = {
				{0, 7}, 
				{6, 8}, 
				{1, 2}, 
				{5, 6}, 
				{4, 2}, 
				{9, 1}
		};
		
		for (int unionIndex = 0; unionIndex < unions.length; unionIndex++) {
			uf.union(unions[unionIndex][0], unions[unionIndex][1]);
			System.out.println(unions[unionIndex][0] + "-" + unions[unionIndex][1] + " => " + uf);
		}
	}
}
