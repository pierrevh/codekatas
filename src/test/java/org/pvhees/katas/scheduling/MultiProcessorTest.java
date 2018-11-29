package org.pvhees.katas.scheduling;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class MultiProcessorTest {

    @Test
    public void oneTaskAndOneProcessor() {
        List<Integer> verdeling = new MultiProcessor().verdeel(1, Arrays.asList(3));

        assertEquals(1, verdeling.size());
        assertEquals(new Integer(3), verdeling.get(0));
    }

    @Test
    public void multipleTaskAndOneProcessor() {
        List<Integer> verdeling = new MultiProcessor().verdeel(1, Arrays.asList(1, 2, 3));

        assertEquals(1, verdeling.size());
        assertEquals(new Integer(6), verdeling.get(0));
    }

    @Test
    public void multipleTaskAndMultipleProcessors() {
        List<Integer> verdeling = new MultiProcessor().verdeel(2, Arrays.asList(1, 2, 3));

        assertEquals(2, verdeling.size());
        assertEquals(new Integer(3), verdeling.get(0));
        assertEquals(new Integer(3), verdeling.get(1));
    }
}