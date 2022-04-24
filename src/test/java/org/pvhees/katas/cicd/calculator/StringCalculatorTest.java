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
}