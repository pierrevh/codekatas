package org.pvhees.katas.diamond;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DiamondTest {
    @Test
    public void sunnyDays() {
        assertEquals("  A  \n B B \nC   C\n B B \n  A  \n", new Diamond().diamond('C', new WestersUppercaseAlfabet()));

        String z = new Diamond().diamond('Z', new WestersUppercaseAlfabet());
        assertTrue(z.contains("Z                                                 Z"));

        assertEquals("--a--\n-b-b-\nc---c\n-b-b-\n--a--\n", new Diamond().diamond('c', new WestersLowercaseAlfabet(), '-'));
    }

    @Test
    public void failForInvalidCharacter() {
        assertThrows(IllegalStateException.class, () ->
                new Diamond().diamond('9', new WestersUppercaseAlfabet())
        );
    }
}