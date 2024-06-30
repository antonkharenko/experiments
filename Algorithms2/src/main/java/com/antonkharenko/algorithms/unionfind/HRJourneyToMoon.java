package com.antonkharenko.algorithms.unionfind;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class HRJourneyToMoon {

    /*
     * Complete the 'journeyToMoon' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY astronaut
     */
    static class UF {
        private final int[] parent;

        UF(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        private int root(int i) {
            int root = i;
            while (root != parent[root]) {
                parent[root] = parent[parent[root]]; // path compression
                root = parent[root];
            }
            return root;
        }

        private void union(int p, int q) {
            int i = root(p);
            int j = root(q);
            parent[i] = parent[j];
        }

        private List<Integer> componentsSizes() {
            Map<Integer, Integer> res = new HashMap<Integer, Integer>();
            for (int i = 0; i < parent.length; i++) {
                int root = root(i);
                if (!res.containsKey(root)) {
                    res.put(root, 0);
                }
                res.put(root, res.get(root) + 1);
            }
            return new ArrayList<>(res.values());
        }
    }

    public static long journeyToMoon(int n, List<List<Integer>> astronaut) {
        // Write your code here
        UF uf = new HRJourneyToMoon.UF(n);
        for(List<Integer> pair: astronaut) {
            uf.union(pair.get(0), pair.get(1));
        }

        List<Integer> componentsSizes = uf.componentsSizes();
        long pairs = 0;
        for (int i = 0; i < componentsSizes.size() - 1; i++) {
            for (int j = i + 1; j < componentsSizes.size(); j++) {
                pairs += componentsSizes.get(i) * componentsSizes.get(j);
            }
        }

        return pairs;
    }

    public static void main(String[] args) {
        int n = 100000;
        List<List<Integer>> astronaut = new ArrayList<>();
        astronaut.add(new ArrayList<>());
        astronaut.add(new ArrayList<>());
        astronaut.get(0).add(1);
        astronaut.get(0).add(2);
        astronaut.get(1).add(3);
        astronaut.get(1).add(4);
        long result = HRJourneyToMoon.journeyToMoon(n, astronaut);
        System.out.println(result); // 4999949998
    }

}
