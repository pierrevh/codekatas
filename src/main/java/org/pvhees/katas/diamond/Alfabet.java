package org.pvhees.katas.diamond;

public interface Alfabet {
    char first();

    char last();

    default int rangnummer(char c) {
        return c - first() + 1;
    }

    default boolean isValid(char c) {
        return (c >= first() && c <= last());
    }

    default char getByIndex(int index) {
        char c = (char) (first() + index);
        if (!isValid(c)) throw new IllegalStateException("index not valid for alfabet");

        return c;
    }
}
