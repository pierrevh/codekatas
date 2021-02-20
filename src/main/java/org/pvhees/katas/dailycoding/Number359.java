package org.pvhees.katas.dailycoding;

import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Number359 {

    public String solve(String input) {
        Map<String, Long> letterCount = Stream.of(input.toLowerCase(Locale.ROOT).split(""))
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        int zero = removeWord(letterCount, "zero", "z");
        int two = removeWord(letterCount, "two", "w");
        int four = removeWord(letterCount, "four", "u");
        int six = removeWord(letterCount, "six", "x");
        int one = removeWord(letterCount, "one", "o");
        int five = removeWord(letterCount, "five", "f");
        int three = removeWord(letterCount, "three", "r");
        int seven = removeWord(letterCount, "seven", "v");
        int eight = removeWord(letterCount, "eight", "g");
        int nine = removeWord(letterCount, "nine", "i");
        return "0".repeat(zero) + "1".repeat(one) + "2".repeat(two) + "3".repeat(three) + "4".repeat(four) +
                "5".repeat(five) + "6".repeat(six) + "7".repeat(seven) + "8".repeat(eight) + "9".repeat(nine);
    }

    private int removeWord(Map<String, Long> letterCount, String word, String keyLetter) {
        Long count = letterCount.get(keyLetter);
        if (count == null) return 0;

        for (String letter : word.split("")) {
            letterCount.put(letter, letterCount.get(letter) - 1);
        }
        return count.intValue();
    }

    public static void main(String[] args) {
        Number359 number359 = new Number359();
        System.out.println(number359.solve("niesevehrtfeev"));
    }
}
