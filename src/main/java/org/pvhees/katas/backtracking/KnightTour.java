package org.pvhees.katas.backtracking;

public class KnightTour {
    private static int[] movesX = new int[]{2, 1, -1, -2, -2, -1, 1, 2};
    private static int[] movesY = new int[]{1, 2, 2, 1, -1, -2, -2, -1};

    private int solutionCounter = 0;
    private int dimension;
    private int[][] board;
    private int startX, startY;

    public KnightTour(int dimension, int startX, int startY) {
        this.dimension = dimension;
        this.startX = startX;
        this.startY = startY;
        this.board = new int[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                board[i][j] = -1;
            }
        }
        this.board[startX][startY] = 1;
    }

    public void solve() {
        knight(startX, startY, 2);
    }

    public void knight(int x, int y, int position) {
        if (position > dimension * dimension) { // position is the number of the move we are about to make. So we have a solution only when we're trying for move 65 ...
            printBoard();
            return;
        }

        for (int i = 0; i < 8; i++) {
            int newX = x + movesX[i];
            int newY = y + movesY[i];
            if (isValidMove(newX, newY, board)) {
                board[newX][newY] = position; // make the current move
                knight(newX, newY, position + 1); // try for next move
                board[newX][newY] = -1; // backtrack
            }
        }
    }

    private void printBoard() {
        solutionCounter++;
        System.out.println("solution:");
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                System.out.print(String.format("%2d ", board[i][j]));
            }
            System.out.println();
        }
        System.out.println();
    }

    private boolean isValidMove(int x, int y, int[][] board) {
        return x >= 0 && x < dimension && y >= 0 && y < dimension && board[x][y] == -1;
    }

    public int getSolutionCounter() {
        return solutionCounter;
    }

    public static void main(String[] args) {
        // Single starting point
//        KnightsTour tour = new KnightsTour(5, 0, 0);
//        tour.solve();
//        System.out.println("# solutions = " + tour.getSolutionCounter());

        // Show solution count for all possible starting points (could be made faster by exploiting symmetry)
        int dim = 5;
        int[][] solutionCounts = new int[dim][dim];
        for (int x = 0; x < dim; x++) {
            for (int y = 0; y < dim; y++) {
                KnightTour tour = new KnightTour(dim, x, y);
                tour.solve();
                solutionCounts[x][y] = tour.getSolutionCounter();
            }
        }
        System.out.println("solution counts for " + dim + "x"+ dim + " board");
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                System.out.print(String.format("%4d ", solutionCounts[i][j]));
            }
            System.out.println();
        }
    }
}
