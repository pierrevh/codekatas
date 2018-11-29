package org.pvhees.katas.life;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class Game2Test {
    private Game2 game2;

    // TODO split up test class into live cell, dead cell, edge-cells (this one not done yet)

    @Before
    public void setUp() throws Exception {
        game2 = new Game2();
    }

    @Test
    public void liveCellWithNoLiveNeighboursDies() {
        String newPlayField = game2.nextGeneration(3, 3, "   \n X \n   \n");
        assertTrue(newPlayField.charAt(5) == ' ');
    }

    @Test
    public void liveCellWithOneLiveNeighbourDies() {
        String newPlayField = game2.nextGeneration(3, 3, " X \n X \n   \n");
        assertTrue(newPlayField.charAt(5) == ' ');
    }

    @Test
    public void liveCellWithTwoLiveNeighboursLives() {
        String newPlayField = game2.nextGeneration(3, 3, " X \n X \n X \n");
        assertTrue(newPlayField.charAt(5) == 'X');
    }

    @Test
    public void liveCellWithThreeLiveNeighboursLives() {
        String newPlayField = game2.nextGeneration(3, 3, " X \nXXX\n   \n");
        assertTrue(newPlayField.charAt(5) == 'X');
    }

    @Test
    public void liveCellWithFourLiveNeighboursDies() {
        String newPlayField = game2.nextGeneration(3, 3, " X \nXXX\n X \n");
        assertTrue(newPlayField.charAt(5) == ' ');
    }

    @Test
    public void liveCellWithFiveLiveNeighboursDies() {
        String newPlayField = game2.nextGeneration(3, 3, " X \nXXX\n XX\n");
        assertTrue(newPlayField.charAt(5) == ' ');
    }

    @Test
    public void liveCellWithSixLiveNeighboursDies() {
        String newPlayField = game2.nextGeneration(3, 3, "XX \nXXX\n XX\n");
        assertTrue(newPlayField.charAt(5) == ' ');
    }

    @Test
    public void liveCellWithSevenLiveNeighboursDies() {
        String newPlayField = game2.nextGeneration(3, 3, "XXX\nXXX\n XX\n");
        assertTrue(newPlayField.charAt(5) == ' ');
    }

    @Test
    public void liveCellWithEightLiveNeighboursDies() {
        String newPlayField = game2.nextGeneration(3, 3, "XXX\nXXX\nXXX\n");
        assertTrue(newPlayField.charAt(5) == ' ');
    }

    @Test
    public void deadCellWithThreeLiveNeighboursLives() {
        String newPlayField = game2.nextGeneration(3, 3, " X \nX X\n   \n");
        assertTrue(newPlayField.charAt(5) == 'X');
    }

    //
    @Test
    public void deadCellWithTwoLiveNeighboursStaysDead() {
        String newPlayField = game2.nextGeneration(3, 3, " X \nX  \n   \n");
        assertTrue(newPlayField.charAt(5) == ' ');
    }

    @Test
    public void deadCellWithOneLiveNeighboursStaysDead() {
        String newPlayField = game2.nextGeneration(3, 3, " X \n   \n   \n");
        assertTrue(newPlayField.charAt(5) == ' ');
    }

    @Test
    public void deadCellWithFourLiveNeighboursStaysDead() {
        String newPlayField = game2.nextGeneration(3, 3, " X \nX  \nXX \n");
        assertTrue(newPlayField.charAt(5) == ' ');
    }
}
