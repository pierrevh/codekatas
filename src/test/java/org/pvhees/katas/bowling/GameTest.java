package org.pvhees.katas.bowling;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {
    private Game game;

    private void rollMany(int rolls, int pins) {
        for (int i = 1; i <= rolls; i++) {
            game.roll(pins);
        }
    }

    private void rollSpare() {
        game.roll(3);
        game.roll(7);
    }

    private void rollStrike() {
        game.roll(10);
    }

    @BeforeEach
    public void setUp() throws Exception {
        game = new Game();
    }

    @Test
    public void gutterGame() {
        rollMany(20, 0);
        assertEquals(0, game.score());
    }

    @Test
    public void singleScores() {
        rollMany(20, 1);
        assertEquals(20, game.score());
    }

    @Test
    public void spare() {
        rollSpare();
        game.roll(9);
        rollMany(17, 0);
        assertEquals(28, game.score());
    }

    @Test
    public void strike() {
        rollStrike();
        game.roll(4);
        game.roll(3);
        rollMany(16, 0);
        assertEquals(24, game.score());
    }

    @Test
    public void perfectGame() {
        rollMany(12, 10);
        assertEquals(300, game.score());
    }

    @Test
    public void actualGame() {
        game.roll(8);
        game.roll(0);
        game.roll(7);
        game.roll(0);
        game.roll(5);
        game.roll(3);
        game.roll(9);
        game.roll(1);
        game.roll(9);
        game.roll(1);
        game.roll(10);
        game.roll(8);
        game.roll(0);
        game.roll(5);
        game.roll(1);
        game.roll(3);
        game.roll(7);
        game.roll(9);
        assertEquals(122, game.score());
    }
}
