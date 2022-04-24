package org.pvhees.katas.dailycoding;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * This problem was asked by Uber.
 *
 * Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.
 *
 * For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].
 *
 * Follow-up: what if you can't use division?
 */
public class Day2 {

    private int myDiv(long dividend, int divisor) {
        int quotient = 0;
        long remainder = dividend;
        while (remainder >= divisor) {
            remainder -= divisor;
            quotient++;
        }
        return quotient;
    }

    private int[] factoringWithDiv(int[] data) {
        long product = 1;
        int[] result = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            product *= data[i];
        }
        for (int i = 0; i < result.length; i++) {
            result[i] = (int) (product / data[i]);
        }

        return result;
    }

    private int[] factoringWithMyDiv(int[] data) {
        long product = 1;
        int[] result = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            product *= data[i];
        }
        for (int i = 0; i < result.length; i++) {
            result[i] = myDiv(product, data[i]);
        }

        return result;
    }

    @Test
    public void factTest() {
        int[] result = factoringWithDiv(new int[]{1, 2, 3, 4, 5});
        assertArrayEquals(new int[]{120, 60, 40, 30, 24}, result);
        result = factoringWithDiv(new int[]{3, 2, 1});
        assertArrayEquals(new int[]{2, 3, 6}, result);
    }

    @Test
    public void factTest2() {
        int[] result = factoringWithMyDiv(new int[]{1, 2, 3, 4, 5});
        assertArrayEquals(new int[]{120, 60, 40, 30, 24}, result);
        result = factoringWithMyDiv(new int[]{3, 2, 1});
        assertArrayEquals(new int[]{2, 3, 6}, result);
    }

    @Test
    public void mydiv() {
        assertEquals(5, myDiv(25, 5));
        assertEquals(0, myDiv(13, 22));
        assertEquals(1, myDiv(7, 5));
    }
}
