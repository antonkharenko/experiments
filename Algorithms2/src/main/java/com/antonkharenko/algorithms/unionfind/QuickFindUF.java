package com.antonkharenko.algorithms.unionfind;

public class QuickFindUF {

    private int[] id;

    public QuickFindUF(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i]=i;
        }
    }

    // O(1)
    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    // O(N)
    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) {
                id[i] = qid;
            }
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
                {8, 9},
                {5, 0},
                {7, 2},
                {6, 1},
                {1, 0},
                {6, 7}
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
