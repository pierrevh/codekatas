package org.pvhees.katas.dynprog;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GridTravelTest {

    @Test
    public void test() {
        GridTravel cut = new GridTravel();
        assertEquals(1, cut.count(1,1));
        assertEquals(3, cut.count(2,3));
        assertEquals(3, cut.count(3,2));
        assertEquals(6, cut.count(3,3));
        assertEquals(2333606220L, cut.count(18,18));
    }
}