package org.pvhees.katas.life;

import java.util.Arrays;

/**
 * Conway's Game Of Life
 * Take 2, more about behaviour
 */
public class Game2 {

    public String nextGeneration(int rows, int cols, String currentState) {
        return nextGeneration(new PlayField(rows, cols, currentState));
    }

    public String nextGeneration(PlayField currentState) {
        PlayField newGeneration = new PlayField(currentState.rows, currentState.columns);
        for (int row = 0; row < currentState.rows; row++) {
            for (int col = 0; col < currentState.columns; col++) {
                if (deadOnNextCycle(currentState, row, col)) {
                    newGeneration.markDead(row, col);
                } else {
                    newGeneration.markAlive(row, col);
                }
            }
        }

        return newGeneration.toString();
    }

    private boolean deadOnNextCycle(PlayField playField, int row, int col) {
        int liveNeighbours = playField.countLiveNeighbours(row, col);
        return playField.isAlive(row, col) ? (liveNeighbours < 2 || liveNeighbours > 3) : (liveNeighbours != 3);
    }

    private static class PlayField {
        private static final char DEAD = ' ';
        private static final char ALIVE = 'X';
        private int rows;
        private int columns;
        private char[][] cells;

        public PlayField(int rows, int columns) {
            this.rows = rows;
            this.columns = columns;
            this.cells = new char[rows][columns];
        }

        public PlayField(int rows, int columns, String state) {
            this(rows, columns);
            int i = 0;
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < columns; col++) {
                    cells[row][col] = state.charAt(i++);
                }
                char newline = state.charAt(i++); // skip newline at end of line
                if (newline != '\n') throw new IllegalArgumentException("Foute input voor speelveld");
            }
        }

        public void markAlive(int row, int col) {
            cells[row][col] = ALIVE;
        }

        public void markDead(int row, int col) {
            cells[row][col] = DEAD;
        }

        public int countLiveNeighbours(int row, int col) {
            if (!isValid(row, col))
                throw new IllegalArgumentException("(" + row + "," + col + ") niet op speelveld");

            int totalAlive = 0;

            // count line above cell
            if (row - 1 >= 0) {
                if (col - 1 >= 0 && cells[row - 1][col - 1] == ALIVE) totalAlive++;
                if (col >= 0 && cells[row - 1][col] == ALIVE) totalAlive++;
                if (col + 1 < columns && cells[row - 1][col + 1] == ALIVE) totalAlive++;
            }

            // count line with cell
            if (col - 1 >= 0 && cells[row][col - 1] == ALIVE) totalAlive++;
            if (col + 1 < columns && cells[row][col + 1] == ALIVE) totalAlive++;

            // count line under cell
            if (row + 1 < columns) {
                if (col - 1 >= 0 && cells[row + 1][col - 1] == ALIVE) totalAlive++;
                if (col >= 0 && cells[row + 1][col] == ALIVE) totalAlive++;
                if (col + 1 < columns && cells[row + 1][col + 1] == ALIVE) totalAlive++;
            }

            return totalAlive;
        }

        public boolean isAlive(int row, int col) {
            return cells[row][col] == ALIVE;
        }

        private boolean isValid(int row, int col) {
            return row >= 0 && row < cells.length && col >= 0 && col < cells[0].length;
        }

        @Override
        public String toString() {
            StringBuilder result = new StringBuilder();
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < columns; col++) {
                    result.append(cells[row][col]);
                }
                result.append('\n');
            }

            return result.toString();
        }
    }
}
