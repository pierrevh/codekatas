package org.pvhees.katas.codility.countriesiter;

import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class CountryCounterQueue {
    public int count(int[][] countryData) {
        int numberOfCountries = 0;

        // Sanitycheck: do we have countries at all?
        if (countryData == null || countryData.length == 0 || countryData[0].length == 0) {
            return numberOfCountries;
        }

        boolean[][] coloured = new boolean[countryData.length][countryData[0].length]; // All false by default

        Queue<Coords> queue = new ConcurrentLinkedQueue<>(); // avoid re-creating queue

        for (int i = 0; i < countryData.length; i++) {
            for (int j = 0; j < countryData[0].length; j++) {
                if (!coloured[i][j]) {
                    markCountry(Coords.of(i, j), coloured, countryData, queue);
                    numberOfCountries++;
                }
            }
        }

        return numberOfCountries;
    }

    private void markCountry(Coords coords, boolean[][] coloured, int[][] input, Queue<Coords> queue) {
        if (!queue.isEmpty()) throw new IllegalStateException("Queue must be empty at start of check");

        int countryColour = input[coords.getI()][coords.getJ()];
        queue.add(coords);

        while (!queue.isEmpty()) {
            Coords currentCell = queue.remove();
            if (!coloured[currentCell.getI()][currentCell.getJ()]) {  // skip already processed items
                coloured[currentCell.getI()][currentCell.getJ()] = true;
                checkNeighbours(currentCell, countryColour, input, coloured, queue);
            }
        }
    }

    private void checkNeighbours(Coords origin, int countryColour, int[][] input, boolean[][] coloured, Queue<Coords> queue) {
        int maxI = input.length - 1;
        int maxJ = input[0].length - 1;

        Coords south = origin.south(maxI, maxJ);
        Coords north = origin.north(maxI, maxJ);
        Coords east = origin.east(maxI, maxJ);
        Coords west = origin.west(maxI, maxJ);
        if (belongsToCountryAndNotYetProcessed(south, countryColour, input, coloured)) {
            queue.add(south);
        }
        if (belongsToCountryAndNotYetProcessed(north, countryColour, input, coloured)) {
            queue.add(north);
        }
        if (belongsToCountryAndNotYetProcessed(east, countryColour, input, coloured)) {
            queue.add(east);
        }
        if (belongsToCountryAndNotYetProcessed(west, countryColour, input, coloured)) {
            queue.add(west);
        }
    }

    private boolean belongsToCountryAndNotYetProcessed(Coords coords, int countryColour, int[][] input, boolean[][] coloured) {
        return coords != null
                && input[coords.getI()][coords.getJ()] == countryColour
                && !coloured[coords.getI()][coords.getJ()];
    }

    private static class Coords {
        private int i;
        private int j;

        private Coords(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        public static Coords of(int i, int j) {
            return new Coords(i, j);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coords coords = (Coords) o;
            return i == coords.i && j == coords.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }

        public Coords north(int maxI, int maxJ) {
            return buildIfValidInGrid(i - 1, j, maxI, maxJ);
        }

        public Coords south(int maxI, int maxJ) {
            return buildIfValidInGrid(i + 1, j, maxI, maxJ);
        }

        public Coords east(int maxI, int maxJ) {
            return buildIfValidInGrid(i, j + 1, maxI, maxJ);
        }

        public Coords west(int maxI, int maxJ) {
            return buildIfValidInGrid(i, j - 1, maxI, maxJ);
        }

        private static Coords buildIfValidInGrid(int i, int j, int maxI, int maxJ) {
            if (i >= 0 && i <= maxI && j >= 0 && j <= maxJ) return new Coords(i, j);

            return null;
        }
    }

}
