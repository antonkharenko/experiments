package com.antonkharenko.algorithms.unionfind;

public class WightedQuickUnionUF {

    private final int[] id;
    private final int[] sz;

    public WightedQuickUnionUF(int N) {
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++) {
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

    public static void main (String[]args){
        int N = 10;
        QuickFindUF uf = new QuickFindUF(N);
        int[][] connections = new int[][]{
                {4, 3},
                {3, 8},
                {6, 5},
                {9, 4},
                {2, 1},
                {8, 9}, // connected
                {5, 0},
                {7, 2},
                {6, 1},
                {1, 0}, // connected
                {6, 7}  // connected
        };
        for (int[] connection : connections) {
            int p = connection[0];
            int q = connection[1];
            if (!uf.connected(p, q)) {
                uf.union(p, q);
                System.out.println(p + " " + q);
            }
        }
    }
}
