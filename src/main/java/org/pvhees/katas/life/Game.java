package org.pvhees.katas.life;

/**
 * Conway's Game Of Life
 * Take 1, very much about implementation
 */
public class Game {
    private Grid grid;

    public Game(int width, int height) {
        this.grid = new Grid(width, height);
    }

    public int getGridWidth() {
        return grid.getWidth();
    }

    public int getGridHeight() {
        return grid.getHeight();
    }

    public void markAlive(int x, int y) {
        grid.markAlive(x, y);
    }

    public boolean isAlive(int x, int y) {
        return grid.get(x, y);
    }

    public void markDead(int x, int y) {
        grid.markDead(x, y);
    }

    public boolean deadOnNextCycle(int x, int y) {
        int liveNeighbours = grid.countLiveNeighbours(x, y);
        return grid.isAlive(x, y) ? (liveNeighbours < 2 || liveNeighbours > 3) : (liveNeighbours != 3);
    }

    public Grid getGrid() {
        return grid;
    }

    private void setGrid(char[][] gridData) {
        if (gridData.length != getGridWidth() * getGridHeight()) {
            throw new IllegalArgumentException("Data is niet van zelfde grootte als het speelbord");
        }
        int width = gridData[0].length;
        int height = gridData.length;

    }

    public void iterate() {
        //TODO
        // create another grid equal in size to current grid
        // check all current cells
        // if cell will be dead in next cycle set corresponding cell in second grid to dead else to alive
        // switch current grid to the new one
    }

    private static class Grid {
        private int width;
        private int height;
        private boolean[][] cells;

        public Grid(int width, int height) {
            this.width = width;
            this.height = height;
            cells = new boolean[height][width];
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }

        public void markAlive(int x, int y) {
            cells[y][x] = true;
        }

        public boolean get(int x, int y) {
            return cells[y][x];
        }

        public void markDead(int x, int y) {
            cells[y][x] = false;
        }

        public int countLiveNeighbours(int x, int y) {
            // TODO isValid(x, y);
            int totalAlive = 0;

            // count line above cell
            if (y - 1 >= 0) {
                if (x-1 >= 0    && cells[y-1][x-1]) totalAlive++;
                if (x >= 0      && cells[y-1][x]) totalAlive++;
                if (x+1 < width && cells[y-1][x+1]) totalAlive++;
            }

            // count line with cell
            if (x-1 >= 0    && cells[y][x-1]) totalAlive++;
            if (x+1 < width && cells[y][x+1]) totalAlive++;

            // count line under cell
            if (y + 1 < width) {
                if (x-1 >= 0    && cells[y+1][x-1]) totalAlive++;
                if (x >= 0      && cells[y+1][x]) totalAlive++;
                if (x+1 < width && cells[y+1][x+1]) totalAlive++;
            }

            return totalAlive;
        }

        public boolean isAlive(int x, int y) {
            return cells[y][x];
        }
    }
}
