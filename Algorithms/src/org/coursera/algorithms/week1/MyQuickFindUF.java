package org.coursera.algorithms.week1;

import java.util.Arrays;

public class MyQuickFindUF {
	
	private int[] id;
	
	public MyQuickFindUF(int n) {
		id = new int[n];
		for (int i = 0; i < n; i++) {
			id[i] = i;
		}
	}
	
	public boolean connected(int p, int q) {
		return id[p] == id[q];
	}
	
	public void union(int p, int q) {
		int pid = id[p];
		int qid = id[q];
		for (int i = 0; i < id.length; i++) {
			if (id[i] == pid) {
				id[i] = qid;
			}
		}
	}

	@Override
	public String toString() {
		return "id = " + Arrays.toString(id);
	}
	
	public static void main(String arg[]) {
		int n = 10;
		MyQuickFindUF uf = new MyQuickFindUF(n);
		int[][] unions = {
				{9, 7}, 
				{5, 1}, 
				{7, 0}, 
				{8, 7}, 
				{7, 6}, 
				{1, 9}
		};
		
		for (int unionIndex = 0; unionIndex < unions.length; unionIndex++) {
			uf.union(unions[unionIndex][0], unions[unionIndex][1]);
			System.out.println(unions[unionIndex][0] + "-" + unions[unionIndex][1] + " => " + uf);
		}
	}
	
	
}
