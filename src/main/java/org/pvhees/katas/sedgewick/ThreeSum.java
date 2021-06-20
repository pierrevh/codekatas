package org.pvhees.katas.sedgewick;


import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;

public class ThreeSum {
    public static int count(int[] a) {
        int size = a.length;
        int cnt = 0;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                for (int k = j + 1; k < size; k++) {
                    if (a[i] + a[j] + a[k] == 0) cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        // this will take a looooooooooooong time
        int[] a = In.readInts("D:\\codekatas\\data-niet-in-git\\algs4-data\\1Mints.txt");
        StdOut.println(count(a));
    }
}
