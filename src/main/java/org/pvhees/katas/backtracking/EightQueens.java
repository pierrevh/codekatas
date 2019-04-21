package org.pvhees.katas.backtracking;

public class EightQueens {
    private int dimension;
    private int[][] board;
    private int solutionCounter;

    public EightQueens(int dimension) {
        this.dimension = dimension;
        this.board = new int[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                board[i][j] = 0;
            }
        }
        this.solutionCounter=0;
    }

    public int getSolutionCounter() {
        return solutionCounter;
    }

    public static void main(String[] args) {
        EightQueens queens = new EightQueens(8);
        queens.solve( 0);
        System.out.println("solutions = " + queens.getSolutionCounter());
    }

    private void solve(int col) {
        if (col>=dimension) {
            printBoard();
            return;
        }

        for (int row=0; row < dimension; row++) {
            if (isSafe(row, col)) {
                board[row][col] = 1;
                solve(col+1);
                board[row][col] = 0;
            }
        }
    }

    private boolean isSafe(int row, int col) {
        int i, j;

        /* Check this row on left side */
        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        /* Check upper diagonal on left side */
        for (i=row, j=col; i>=0 && j>=0; i--, j--)
            if (board[i][j] == 1)
                return false;

        /* Check lower diagonal on left side */
        for (i=row, j=col; j>=0 && i<dimension; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
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

}
