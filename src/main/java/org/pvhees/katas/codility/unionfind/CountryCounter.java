package org.pvhees.katas.codility.unionfind;

import edu.princeton.cs.algorithms.WeightedQuickUnionUF;

public class CountryCounter {
    WeightedQuickUnionUF uf;

    public CountryCounter(int[][] countryData) {
        // Sanitycheck: we need data
        if (countryData == null || countryData.length == 0 || countryData[0].length == 0) {
            throw new IllegalArgumentException("no data");
        }
        this.uf = new WeightedQuickUnionUF(countryData.length * countryData[0].length);
        load(countryData);
    }

    private int[] neighbourIndexes = new int[]{0, -1, 0, +1, -1, 0, +1, 0};

    private void load(int[][] countryData) {
        int cols = countryData[0].length;
        for (int row = 0; row < countryData.length; row++) {
            for (int col = 0; col < countryData[0].length; col++) {
                for (int i = 0; i < neighbourIndexes.length; i += 2) {
                    int nextRow = row + neighbourIndexes[i];
                    int nextCol = col + neighbourIndexes[i + 1];
                    if (valid(nextRow, nextCol, countryData.length, countryData[0].length))
                        if (countryData[row][col] == countryData[nextRow][nextCol]) {
                            uf.union(row * cols + col, nextRow * cols + nextCol);
                        }
                }
            }
        }
    }

    private boolean valid(int row, int col, int rows, int cols) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    public int count() {
        return uf.count();
    }
}
