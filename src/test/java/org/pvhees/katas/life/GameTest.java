package org.pvhees.katas.life;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class GameTest {
    private static final int GRID_WIDTH = 10;
    private static final int GRID_HEIGHT = 50;

    @Test
    public void newGame() {
        Game game = new Game(GRID_WIDTH, GRID_HEIGHT);
        assertEquals(GRID_WIDTH, game.getGridWidth());
        assertEquals(GRID_HEIGHT, game.getGridHeight());
    }

    @Test
    public void setsCellAlive() {
        int x = 0, y = 0;
        Game game = new Game(GRID_WIDTH, GRID_HEIGHT);

        game.markAlive(x, y);

        assertEquals(true, game.isAlive(x, y));
    }

    @Test
    public void setsCellDead() {
        int x = 0, y = 0;
        Game game = new Game(GRID_WIDTH, GRID_HEIGHT);

        game.markDead(x, y);

        assertEquals(false, game.isAlive(x, y));
    }

    @Test
    public void settingCellOutsideWidthGivesException() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
                    int x = GRID_WIDTH, y = 0;
                    Game game = new Game(GRID_WIDTH, GRID_HEIGHT);

                    game.markAlive(x, y);
                }
        );
    }

    @Test
    public void settingCellOutsideHeightGivesException() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            int x = 0, y = GRID_HEIGHT;
            Game game = new Game(GRID_WIDTH, GRID_HEIGHT);

            game.markAlive(x, y);
        });
    }

    @Test
    public void settingCellWithNegativeHeightIndexGivesException() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            int x = GRID_WIDTH, y = -1;
            Game game = new Game(GRID_WIDTH, GRID_HEIGHT);

            game.markAlive(x, y);
        });
    }

    @Test
    public void settingCellWithNegativeWidthIndexGivesException() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            int x = -1, y = GRID_HEIGHT;
            Game game = new Game(GRID_WIDTH, GRID_HEIGHT);

            game.markAlive(x, y);
        });
    }

    // A live cell with fewer than two live neighbours dies
    @Test
    public void cellWithOneLiveNeighbourDies() {
        Game game = new Game(GRID_WIDTH, GRID_HEIGHT);
        // C is the cell we're interested in: - means dead, x means alive
        // - - -
        // - C -
        // - x -
        game.markDead(0, 0);
        game.markDead(1, 0);
        game.markDead(2, 0);
        game.markDead(0, 1);
        game.markAlive(1, 1);
        game.markDead(2, 1);
        game.markDead(0, 2);
        game.markAlive(1, 2);
        game.markDead(2, 2);

        assertTrue(game.deadOnNextCycle(1, 1));
    }

    @Test
    public void cellWithNoLiveNeighboursDies() {
        Game game = new Game(GRID_WIDTH, GRID_HEIGHT);
        // C is the cell we're interested in: - means dead
        // - - -
        // - C -
        // - - -
        game.markDead(0, 0);
        game.markDead(1, 0);
        game.markDead(2, 0);
        game.markDead(0, 1);
        game.markAlive(1, 1);
        game.markDead(2, 1);
        game.markDead(0, 2);
        game.markDead(1, 2);
        game.markDead(2, 2);

        assertTrue(game.deadOnNextCycle(1, 1));
    }

    // A live cell with more than three live neighbours dies
    @Test
    public void cellWithFourLiveNeighboursDies() {
        Game game = new Game(GRID_WIDTH, GRID_HEIGHT);
        // C is the cell we're interested in: - means dead, x means alive
        // - x -
        // x C x
        // - x -
        game.markDead(0, 0);
        game.markAlive(1, 0);
        game.markDead(2, 0);
        game.markAlive(0, 1);
        game.markAlive(1, 1);
        game.markAlive(2, 1);
        game.markDead(0, 2);
        game.markAlive(1, 2);
        game.markDead(2, 2);

        assertTrue(game.deadOnNextCycle(1, 1));
    }

    @Test
    public void cellWithFiveLiveNeighboursDies() {
        Game game = new Game(GRID_WIDTH, GRID_HEIGHT);
        // C is the cell we're interested in: - means dead, x means alive
        // - x x
        // x C x
        // - x -
        game.markDead(0, 0);
        game.markAlive(1, 0);
        game.markAlive(2, 0);
        game.markAlive(0, 1);
        game.markAlive(1, 1);
        game.markAlive(2, 1);
        game.markDead(0, 2);
        game.markAlive(1, 2);
        game.markDead(2, 2);

        assertTrue(game.deadOnNextCycle(1, 1));
    }

    @Test
    public void cellWithSixLiveNeighboursDies() {
        Game game = new Game(GRID_WIDTH, GRID_HEIGHT);
        // C is the cell we're interested in: - means dead, x means alive
        // x x -
        // x C x
        // - x x
        game.markAlive(0, 0);
        game.markAlive(1, 0);
        game.markDead(2, 0);
        game.markAlive(0, 1);
        game.markAlive(1, 1);
        game.markAlive(2, 1);
        game.markDead(0, 2);
        game.markAlive(1, 2);
        game.markAlive(2, 2);

        assertTrue(game.deadOnNextCycle(1, 1));
    }

    @Test
    public void cellWithSevenLiveNeighboursDies() {
        Game game = new Game(GRID_WIDTH, GRID_HEIGHT);
        // C is the cell we're interested in: - means dead, x means alive
        // X x -
        // x C x
        // X x X
        game.markAlive(0, 0);
        game.markAlive(1, 0);
        game.markDead(2, 0);
        game.markAlive(0, 1);
        game.markAlive(1, 1);
        game.markAlive(2, 1);
        game.markAlive(0, 2);
        game.markAlive(1, 2);
        game.markAlive(2, 2);

        assertTrue(game.deadOnNextCycle(1, 1));
    }

    @Test
    public void cellWithEightLiveNeighboursDies() {
        Game game = new Game(GRID_WIDTH, GRID_HEIGHT);
        // C is the cell we're interested in: - means dead, x means alive
        // x x x
        // x C x
        // x x x
        game.markAlive(0, 0);
        game.markAlive(1, 0);
        game.markAlive(2, 0);
        game.markAlive(0, 1);
        game.markAlive(1, 1);
        game.markAlive(2, 1);
        game.markAlive(0, 2);
        game.markAlive(1, 2);
        game.markAlive(2, 2);

        assertTrue(game.deadOnNextCycle(1, 1));
    }

    // A live cell with two or three live neighbours lives on to the next generation.
    @Test
    public void cellWithTwoLiveNeighboursLives() {
        Game game = new Game(GRID_WIDTH, GRID_HEIGHT);
        // C is the cell we're interested in: - means dead, x means alive
        // - - -
        // x C x
        // - - -
        game.markDead(0, 0);
        game.markDead(1, 0);
        game.markDead(2, 0);
        game.markAlive(0, 1);
        game.markAlive(1, 1);
        game.markAlive(2, 1);
        game.markDead(0, 2);
        game.markDead(1, 2);
        game.markDead(2, 2);

        assertFalse(game.deadOnNextCycle(1, 1));
    }

    @Test
    public void liveCellWithThreeLiveNeighboursLives() {
        Game game = new Game(GRID_WIDTH, GRID_HEIGHT);
        // C is the cell we're interested in: - means dead, x means alive
        // - X -
        // x C x
        // - - -
        game.markDead(0, 0);
        game.markAlive(1, 0);
        game.markDead(2, 0);
        game.markAlive(0, 1);
        game.markAlive(1, 1);
        game.markAlive(2, 1);
        game.markDead(0, 2);
        game.markDead(1, 2);
        game.markDead(2, 2);

        assertFalse(game.deadOnNextCycle(1, 1));
    }

    // A dead cell with exactly three live neighbours becomes a live cell.
    @Test
    public void deadCellWithThreeLiveNeighboursLives() {
        Game game = new Game(GRID_WIDTH, GRID_HEIGHT);
        // C is the cell we're interested in: - means dead, x means alive
        // - X -
        // x C x
        // - - -
        game.markDead(0, 0);
        game.markAlive(1, 0);
        game.markDead(2, 0);
        game.markAlive(0, 1);
        game.markDead(1, 1);
        game.markAlive(2, 1);
        game.markDead(0, 2);
        game.markDead(1, 2);
        game.markDead(2, 2);

        assertFalse(game.deadOnNextCycle(1, 1));
    }

    @Test
    public void deadCellWithTwoLiveNeighboursStaysDead() {
        Game game = new Game(GRID_WIDTH, GRID_HEIGHT);
        // C is the cell we're interested in: - means dead, x means alive
        // - X -
        // x C -
        // - - -
        game.markDead(0, 0);
        game.markAlive(1, 0);
        game.markDead(2, 0);
        game.markAlive(0, 1);
        game.markDead(1, 1);
        game.markDead(2, 1);
        game.markDead(0, 2);
        game.markDead(1, 2);
        game.markDead(2, 2);

        assertTrue(game.deadOnNextCycle(1, 1));
    }

    @Test
    public void deadCellWithOneLiveNeighboursStaysDead() {
        Game game = new Game(GRID_WIDTH, GRID_HEIGHT);
        // C is the cell we're interested in: - means dead, x means alive
        // - - -
        // x C -
        // - - -
        game.markDead(0, 0);
        game.markDead(1, 0);
        game.markDead(2, 0);
        game.markAlive(0, 1);
        game.markDead(1, 1);
        game.markDead(2, 1);
        game.markDead(0, 2);
        game.markDead(1, 2);
        game.markDead(2, 2);

        assertTrue(game.deadOnNextCycle(1, 1));
    }

    @Test
    public void deadCellWithFourLiveNeighboursStaysDead() {
        Game game = new Game(GRID_WIDTH, GRID_HEIGHT);
        // C is the cell we're interested in: - means dead, x means alive
        // x x x
        // x C -
        // - - -
        game.markAlive(0, 0);
        game.markAlive(1, 0);
        game.markAlive(2, 0);
        game.markAlive(0, 1);
        game.markDead(1, 1);
        game.markDead(2, 1);
        game.markDead(0, 2);
        game.markDead(1, 2);
        game.markDead(2, 2);

        assertTrue(game.deadOnNextCycle(1, 1));
    }

    private void setGrid(char[][] gridData) {
        int width = gridData[0].length;
        int height = gridData.length;
        System.out.println("width  = " + width);
        System.out.println("height = " + height);
    }

    @Test
    public void experiment() {
        setGrid(new char[10][50]);
    }
}