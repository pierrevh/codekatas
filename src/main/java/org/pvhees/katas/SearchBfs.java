package org.pvhees.katas;

import java.util.Stack;

public class SearchBfs {
    private final int[][] input = new int[][]{
            {1, 2, 2, 3, 3},
            {2, 2, 2, 2, 3},
            {5, 5, 5, 4, 4},
            {7, 6, 6, 4, 4},
            {7, 7, 8, 8, 8}
    };
    private final int rows = input.length;
    private final int cols = input[0].length;
    private final boolean[][] visited = new boolean[rows][cols];

    public static void main(String[] args) {
        SearchBfs searchDfs = new SearchBfs();
        searchDfs.processComponents();
    }

    private void processComponents() {
        int componentCount = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j]) {
                    componentCount++;
                    processComponent(i, j);
                }
            }
        }
        System.out.println("componentCount = " + componentCount);
    }

    private void processComponent(int i, int j) {
        int itemCount = 0;
        Stack<Cell> frontier = new Stack<>();
        frontier.push(new Cell(i, j));
        while (!frontier.empty()) {
            Cell current = frontier.pop();
            if (!visited[current.i][current.j]) {
                itemCount++;
                visited[current.i][current.j] = true;
                checkNeighbours(current.i, current.j, input[current.i][current.j], frontier);
            }
        }
        System.out.println("itemCount = " + itemCount);
    }

    private void checkNeighbours(int i, int j, int value, Stack<Cell> frontier) {
        int[] di = {0, 0, -1, 1};
        int[] dj = {-1, 1, 0, 0};
        for (int x = 0; x < di.length; x++) {
            int newi = i + di[x];
            int newj = j + dj[x];
            if (newi >= 0 && newi < rows && newj >= 0 && newj < cols && input[newi][newj] == value && !visited[newi][newj]) {
                frontier.push(new Cell(newi, newj));
            }
        }
    }

    private static class Cell {
        int i;
        int j;

        public Cell(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
