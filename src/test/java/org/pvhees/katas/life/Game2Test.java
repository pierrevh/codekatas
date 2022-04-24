package org.pvhees.katas.life;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Game2Test {
    private Game2 game2;

    // TODO split up test class into live cell, dead cells, an d to build: cells on the edge, some interesting patterns (acceptance test)

    @BeforeEach
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

    @Test
    public void gliderPattern() {
        String startingPlayField = " X        \n  X       \nXXX       \n          \n          \n          \n          \n          \n          \n          \n";
        String playField = startingPlayField;
        for (int i = 0; i < 10; i++) {
            System.out.println(playField);
            playField = game2.nextGeneration(10, 10, playField);
        }
    }
}
