package org.pvhees.katas.wordwrap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WrapperTest {

    @Test
    public void nullTextThrows() {
        assertThrows(NullPointerException.class, () -> Wrapper.wrap(null, 0));
    }

    @Test
    public void emptyTextFitsAlways() {
        assertEquals("", Wrapper.wrap("", 0));
        assertEquals("", Wrapper.wrap("", 1));
        assertEquals("", Wrapper.wrap("", 2));
    }

    @Test
    public void textFitsLine() {
        assertEquals("x", Wrapper.wrap("x", 1));
        assertEquals("x", Wrapper.wrap("x", 2));
        assertEquals("xxxxx", Wrapper.wrap("xxxxx", 5));
        assertEquals("xxxxx", Wrapper.wrap("xxxxx", 6));
        assertEquals("xxx xx", Wrapper.wrap("xxx xx", 6));
    }

    @Test
    public void textWithOneBreakBetweenWords() {
        assertEquals("xx\nxx", Wrapper.wrap("xx xx", 2));
    }

    @Test
    public void multiWordTextOneBreakAfterWord() {
        assertEquals("xx xx\nxxx", Wrapper.wrap("xx xx xxx", 5));
    }

    @Test
    public void multipleBreaks() {
        assertEquals("xx\nxxx\nxx", Wrapper.wrap("xx xxx xx", 3));
    }

    @Test
    public void textBreaksInsideWord() {
        assertEquals("xx\nabcde\nf xx", Wrapper.wrap("xx abcdef xx", 5));
    }

    @Test
    public void acceptanceTest() {
        assertEquals("Piet loopt naar de fiets.\nSint is er\nsupercalifragilisticexpia\nlidocious van.",
                Wrapper.wrap("Piet loopt naar de fiets. Sint is er supercalifragilisticexpialidocious van.", 25));
    }
}
