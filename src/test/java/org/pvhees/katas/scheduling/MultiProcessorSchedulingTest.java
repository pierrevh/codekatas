package org.pvhees.katas.scheduling;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiProcessorSchedulingTest {

    @Test
    public void oneTaskAndOneProcessor() {
        List<Integer> verdeling = new MultiProcessorScheduling().verdeel(1, Arrays.asList(3));

        assertEquals(1, verdeling.size());
        assertEquals(new Integer(3), verdeling.get(0));
    }

    @Test
    public void multipleTaskAndOneProcessor() {
        List<Integer> verdeling = new MultiProcessorScheduling().verdeel(1, Arrays.asList(1, 2, 3));

        assertEquals(1, verdeling.size());
        assertEquals(new Integer(6), verdeling.get(0));
    }

    @Test
    public void multipleTaskAndMultipleProcessors() {
        List<Integer> verdeling = new MultiProcessorScheduling().verdeel(2, Arrays.asList(1, 2, 3));

        assertEquals(2, verdeling.size());
        assertEquals(new Integer(3), verdeling.get(0));
        assertEquals(new Integer(3), verdeling.get(1));
    }

    @Test
    public void acceptanceTest() {
        List<Integer> verdeling = new MultiProcessorScheduling().verdeel(4, Arrays.asList(3,5,5,9,12,6,8));

        assertEquals(4, verdeling.size());
        assertEquals(new Integer(13), verdeling.get(0));
        assertEquals(new Integer(12), verdeling.get(1));
        assertEquals(new Integer(12), verdeling.get(2));
        assertEquals(new Integer(11), verdeling.get(3));
    }

}