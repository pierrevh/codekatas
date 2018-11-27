package org.pvhees.katas.diamond;

import java.util.Arrays;

public class Diamond {

    private static final char DEFAULT_BACKGROUND = ' ';

    public String diamond(char c, Alfabet alfabet) {
        return diamond(c, alfabet, DEFAULT_BACKGROUND);
    }

    public String diamond(char c, Alfabet alfabet, char background) {
        if (!alfabet.isValid(c)) throw new IllegalStateException("Bad character for alfabet");

        StringBuilder result = new StringBuilder();
        int rangnummer = alfabet.rangnummer(c);
        int length = (rangnummer * 2) - 1;
        for (int index = 0; index < rangnummer; index++) {
            result.append(buildLine(length, index, alfabet, background));
            result.append("\n");
        }
        for (int index = rangnummer - 2; index >= 0; index--) {
            result.append(buildLine(length, index, alfabet, background));
            result.append("\n");
        }
        return result.toString();
    }

    private static String buildLine(int length, int index, Alfabet alfabet, char background) {
        char[] line = buildEmptyLine(length, background);

        char c = alfabet.getByIndex(index);

        int mid = length / 2;
        line[mid - index] = c;
        line[mid + index] = c;

        return new String(line);
    }

    private static char[] buildEmptyLine(int length, char background) {
        char line[] = new char[length];

        Arrays.fill(line, background);

        return line;
    }
}
