package org.pvhees.katas.sedgewick;

import edu.princeton.cs.algorithms.BinarySearch;
import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;

import java.util.Arrays;

public class TwoSumFast {
    public static int count(int[] a) {
        Arrays.sort(a);
        int size = a.length;
        int cnt = 0;
        for (int i = 0; i < size; i++) {
            if (BinarySearch.rank(-a[i], a) > i) cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] a = In.readInts("D:\\codekatas\\data-niet-in-git\\algs4-data\\1Mints.txt");
        StdOut.println(count(a));
    }
}
