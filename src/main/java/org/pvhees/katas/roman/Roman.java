package org.pvhees.katas.roman;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Roman {
    private final static Map<Integer, String> ROMANS = new TreeMap<>(Comparator.reverseOrder());

    static {
        ROMANS.put(1, "I");
        ROMANS.put(4, "IV");
        ROMANS.put(5, "V");
        ROMANS.put(9, "IX");
        ROMANS.put(10, "X");
        ROMANS.put(40, "XL");
        ROMANS.put(45, "VL");
        ROMANS.put(49, "IL");
        ROMANS.put(50, "L");
        ROMANS.put(90, "XC");
        ROMANS.put(95, "VC");
        ROMANS.put(99, "IC");
        ROMANS.put(100, "C");
        ROMANS.put(400, "CD");
        ROMANS.put(450, "LD");
        ROMANS.put(490, "XD");
        ROMANS.put(495, "VD");
        ROMANS.put(499, "ID");
        ROMANS.put(500, "D");
        ROMANS.put(900, "CM");
        ROMANS.put(950, "LM");
        ROMANS.put(990, "XM");
        ROMANS.put(995, "VM");
        ROMANS.put(999, "IM");
        ROMANS.put(1000, "M");
    }

    public static String toRoman(final int num) {
        StringBuilder result = new StringBuilder();
        int remainder = num;
        Iterator<Integer> iterator = ROMANS.keySet().iterator();
        while (iterator.hasNext()) {
            int divisor = iterator.next();
            //System.out.println("divisor = " + divisor);
            int times = remainder / divisor;
            String numeral = ROMANS.get(divisor);
            for (; times > 0; times--) {
                result.append(numeral);
            }
            remainder %= divisor;
        }

        return result.toString();
    }

    public static String fromRoman(String roman) {
        return null; //TODO
    }

}