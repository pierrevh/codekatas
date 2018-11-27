package org.pvhees.katas.wordwrap;

public class Wrapper {
    private Wrapper() {
        // utility
    }

    public static String wrap(String text, int columns) {
        // base case
        if (text.length() <= columns)
            return text;

        // recurse
        int split = text.lastIndexOf(' ', columns);
        int restStartsFrom = split + 1; // skip the space
        if (split == -1) {
            split = columns;
            restStartsFrom = split;
        }

        return text.substring(0, split) + "\n" + wrap(text.substring(restStartsFrom), columns);
    }
}
