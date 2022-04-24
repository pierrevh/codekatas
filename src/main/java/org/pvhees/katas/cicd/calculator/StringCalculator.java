package org.pvhees.katas.cicd.calculator;

import java.util.Arrays;
import java.util.List;

public class StringCalculator {
    public int add(String s) {
        if (s == null || s.isBlank()) {
            return 0;
        }

        return Arrays.stream(s.split(","))
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
