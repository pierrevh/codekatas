package org.pvhees.katas.roman;

import java.util.*;

public class Roman {
    private final static Map<Integer, String> DECIMAL_TO_ROMAN = new TreeMap<>(Comparator.reverseOrder());
    private final static Map<Character, Integer> ROMAN_TO_DECIMAL = new HashMap<>();

    static {
        DECIMAL_TO_ROMAN.put(1, "I");
        DECIMAL_TO_ROMAN.put(4, "IV");
        DECIMAL_TO_ROMAN.put(5, "V");
        DECIMAL_TO_ROMAN.put(9, "IX");
        DECIMAL_TO_ROMAN.put(10, "X");
        DECIMAL_TO_ROMAN.put(40, "XL");
        DECIMAL_TO_ROMAN.put(45, "VL");
        DECIMAL_TO_ROMAN.put(49, "IL");
        DECIMAL_TO_ROMAN.put(50, "L");
        DECIMAL_TO_ROMAN.put(90, "XC");
        DECIMAL_TO_ROMAN.put(95, "VC");
        DECIMAL_TO_ROMAN.put(99, "IC");
        DECIMAL_TO_ROMAN.put(100, "C");
        DECIMAL_TO_ROMAN.put(400, "CD");
        DECIMAL_TO_ROMAN.put(450, "LD");
        DECIMAL_TO_ROMAN.put(490, "XD");
        DECIMAL_TO_ROMAN.put(495, "VD");
        DECIMAL_TO_ROMAN.put(499, "ID");
        DECIMAL_TO_ROMAN.put(500, "D");
        DECIMAL_TO_ROMAN.put(900, "CM");
        DECIMAL_TO_ROMAN.put(950, "LM");
        DECIMAL_TO_ROMAN.put(990, "XM");
        DECIMAL_TO_ROMAN.put(995, "VM");
        DECIMAL_TO_ROMAN.put(999, "IM");
        DECIMAL_TO_ROMAN.put(1000, "M");

        ROMAN_TO_DECIMAL.put('I',    1);
        ROMAN_TO_DECIMAL.put('V',    5);
        ROMAN_TO_DECIMAL.put('X',   10);
        ROMAN_TO_DECIMAL.put('L',   50);
        ROMAN_TO_DECIMAL.put('C',  100);
        ROMAN_TO_DECIMAL.put('D',  500);
        ROMAN_TO_DECIMAL.put('M', 1000);
    }

    public static String toRoman(final int num) {
        StringBuilder result = new StringBuilder();
        int remainder = num;
        Iterator<Integer> iterator = DECIMAL_TO_ROMAN.keySet().iterator();
        while (iterator.hasNext()) {
            int divisor = iterator.next();
            //System.out.println("divisor = " + divisor);
            int times = remainder / divisor;
            String numeral = DECIMAL_TO_ROMAN.get(divisor);
            for (; times > 0; times--) {
                result.append(numeral);
            }
            remainder %= divisor;
        }

        return result.toString();
    }

    public static int fromRoman(String roman) {
        int previousValue = 0;
        int total = 0;
        for (int i = roman.length()-1; i >= 0; i--) {
            Integer currentValue = ROMAN_TO_DECIMAL.get(roman.charAt(i));
            if (currentValue < previousValue) {
                total -= currentValue;
            } else {
                total += currentValue;
            }
            previousValue = currentValue;
        }

        return total;
    }

}