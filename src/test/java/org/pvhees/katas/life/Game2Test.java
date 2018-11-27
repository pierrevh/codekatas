package org.pvhees.katas.life;

import org.junit.Test;

public class Game2Test {
    @Test
    public void x() {
        Game2 game2 = new Game2();
        String playField = game2.nextGeneration(5, 5, "   X \n  XX \n   XX\n     \nXXXXX\n");
        System.out.println(playField);
    }
}
