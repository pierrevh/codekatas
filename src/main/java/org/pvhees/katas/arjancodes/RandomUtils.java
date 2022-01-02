package org.pvhees.katas.arjancodes;

import java.util.Objects;
import java.util.Random;

public class RandomUtils {
    private RandomUtils() {
        // Util
    }

    public static String randomFromAlphabet(int length, String alphabet) {
        Objects.requireNonNull(alphabet);
        if (alphabet.isEmpty()) throw new IllegalArgumentException("alphabet moet minstens 1 teken bevatten");
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++)
            sb.append(alphabet.charAt(rnd.nextInt(alphabet.length())));

        return sb.toString();
    }

    public static String randomLetters(int length) {
        return randomFromAlphabet(length, "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
    }

    public static String randomDigits(int length) {
        return randomFromAlphabet(length, "0123456789");
    }
}
