package org.pvhees.katas.sedgewick;

public class Stopwatch {
    private final long start;

    public Stopwatch() {
        this.start = System.currentTimeMillis();
    }

    public double elapsedSeconds() {
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }
}
