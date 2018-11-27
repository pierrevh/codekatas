package org.pvhees.katas.bowling;

public class Game {
    private static final int NUMBER_OF_FRAMES = 10;
    private static final int ALL_PINS_IN_FRAME = 10;
    private int[] rolls = new int[21];
    private int currentRoll = 0;

    public Game() {
    }

    public void roll(int pins) {
        rolls[currentRoll++] = pins;
    }

    public int score() {
        int total = 0;
        int firstInFrame = 0;

        for (int frame = 1; frame <= NUMBER_OF_FRAMES; frame++) {
            if (isStrike(firstInFrame)) {
                total += ALL_PINS_IN_FRAME + strikeBonus(firstInFrame);
                firstInFrame++;  // advance to next frame after strike
            } else if (isSpare(firstInFrame)) {
                total += ALL_PINS_IN_FRAME + spareBonus(firstInFrame);
                firstInFrame += 2; // advance to next frame
            } else {
                total += basicScore(firstInFrame);
                firstInFrame += 2; // advance to next frame
            }
        }

        return total;
    }

    private boolean isSpare(int firstInFrame) {
        return rolls[firstInFrame] + rolls[firstInFrame + 1] == ALL_PINS_IN_FRAME;
    }

    private boolean isStrike(int firstInFrame) {
        return rolls[firstInFrame] == ALL_PINS_IN_FRAME;
    }

    private int basicScore(int firstInFrame) {
        return rolls[firstInFrame] + rolls[firstInFrame + 1];
    }

    private int strikeBonus(int firstInFrame) {
        return rolls[firstInFrame + 1] + rolls[firstInFrame + 2];
    }

    private int spareBonus(int firstInFrame) {
        return rolls[firstInFrame + 2];
    }
}