package org.pvhees.katas.arjancodes.cohesioncoupling.start;

import java.util.Locale;
import java.util.Random;

public class VehicleRegistry {

    // General utilities
    private static String randomFromAlphabet(int length, String alphabet) {
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++)
            sb.append(alphabet.charAt(rnd.nextInt(alphabet.length())));

        return sb.toString();
    }

    private static String randomLetters(int length) {
        return randomFromAlphabet(length, "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
    }

    private static String randomDigits(int length) {
        return randomFromAlphabet(length, "0123456789");
    }

    // Vehicle utilities
    public String generateVehicleId() {
        return randomLetters(12).toUpperCase(Locale.ROOT);
    }

    public String generateVehicleLicense(String id) {
        return id.substring(0, 2) + "-" + randomLetters(3) + "-" + randomDigits(1);
    }

    public static void main(String[] args) {
        VehicleRegistry registry = new VehicleRegistry();
        for (int i = 0; i < 10; i++)
            System.out.println(registry.generateVehicleLicense(registry.generateVehicleId()));
    }
}
