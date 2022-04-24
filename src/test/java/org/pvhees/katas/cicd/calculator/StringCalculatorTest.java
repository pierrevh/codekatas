package org.pvhees.katas.cicd.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    @Test
    void shouldReturnZeroForEmptyInput() {
        StringCalculator subject = new StringCalculator();
        int sum = subject.add("");
        assertEquals(0, sum);
    }

    @Test
    void shouldReturnTheSameNumberForOneNumber() {
        StringCalculator subject = new StringCalculator();
        int sum = subject.add("1");
        assertEquals(1, sum);
    }

    @Test
    void shouldReturnSumForTwoNumbers() {
        StringCalculator subject = new StringCalculator();
        int sum = subject.add("1,2");
        assertEquals(3, sum);
    }
}