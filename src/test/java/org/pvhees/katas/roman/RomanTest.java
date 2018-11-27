package org.pvhees.katas.roman;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.pvhees.katas.roman.Roman.toRoman;

public class RomanTest {
    @Test
    public void numberMapsToSingleRomanCharacter() {
        assertEquals("I", toRoman(1));
        assertEquals("V", toRoman(5));
        assertEquals("X", toRoman(10));
        assertEquals("L", toRoman(50));
        assertEquals("C", toRoman(100));
        assertEquals("D", toRoman(500));
        assertEquals("M", toRoman(1000));
    }

    @Test
    public void numberWithoutSubtractiveRomanNumeral() {
        assertEquals("VI", toRoman(6));
        assertEquals("VIII", toRoman(8));
        assertEquals("MMDCCLXXVIII", toRoman(2778));
    }

    @Test
    public void numberWithSubtractiveRomanNumeral() {
        assertEquals("IV", toRoman(4));
        assertEquals("IX", toRoman(9));
        assertEquals("MCMIL", toRoman(1949));
    }
}
