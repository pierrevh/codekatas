package org.pvhees.katas;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class SearchDfs {
    private final int[][] input = new int[][]{
            {1, 2, 2, 3, 3},
            {2, 2, 2, 2, 3},
            {4, 4, 4, 5, 5},
            {6, 7, 7, 5, 5},
            {6, 6, 8, 8, 8}
    };
    private final int rows = input.length;
    private final int cols = input[0].length;
    private final boolean[][] visited = new boolean[rows][cols];

    public static void main(String[] args) {
        SearchDfs searchDfs = new SearchDfs();
        searchDfs.processComponents();
    }

    private void processComponents() {
        int componentCount = 0;
        int maxItemCount = Integer.MIN_VALUE;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j]) {
                    componentCount++;
                    int itemCount = processComponent(i, j);
                    if (itemCount > maxItemCount) {
                        maxItemCount = itemCount;
                    }
                    System.out.println("#items in component[" + componentCount + "] = " + itemCount);
                }
            }
        }
        System.out.println("componentCount = " + componentCount);
        System.out.println("Largest component has "+ maxItemCount + " items");
    }

    private int processComponent(int i, int j) {
        int itemCount = 0;
        Queue<Cell> frontier = new LinkedBlockingQueue<>();
        frontier.offer(new Cell(i, j));
        while (!frontier.isEmpty()) {
            Cell current = frontier.poll();
            if (!visited[current.i][current.j]) {
                itemCount++;
                visited[current.i][current.j] = true;
                checkNeighbours(current.i, current.j, input[current.i][current.j], frontier);
            }
        }
        return itemCount;
    }

    private void checkNeighbours(int i, int j, int value, Queue<Cell> frontier) {
        int[] di = {0, 0, -1, 1};
        int[] dj = {-1, 1, 0, 0};
        for (int x = 0; x < di.length; x++) {
            int newi = i + di[x];
            int newj = j + dj[x];
            if (newi >= 0 && newi < rows && newj >= 0 && newj < cols && input[newi][newj] == value && !visited[newi][newj]) {
                frontier.offer(new Cell(newi, newj));
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
