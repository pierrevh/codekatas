package org.pvhees.katas.arjancodes.cohesioncoupling;

import java.util.*;

import static org.pvhees.katas.arjancodes.cohesioncoupling.RandomUtils.randomDigits;
import static org.pvhees.katas.arjancodes.cohesioncoupling.RandomUtils.randomLetters;

public class VehicleRegistry {
    private static final List<VehicleInfo> VEHICLE_INFOS = List.of(
            new VehicleInfo("Tesla", 60000, true),
            new VehicleInfo("Volvo", 35000, true),
            new VehicleInfo("BMW", 45000, false));
    private static final Map<String, VehicleInfo> VEHICLE_INFO_DB = new HashMap<>();

    static {
        VEHICLE_INFOS.forEach(vi -> VEHICLE_INFO_DB.put(vi.getBrand(), vi));
    }

    private String generateVehicleId() {
        return randomLetters(12).toUpperCase();
    }

    private String generateVehicleLicense(String id) {
        Objects.requireNonNull(id);
        if (id.length() < 2) throw new IllegalArgumentException("VehicleId moet minstens 2 lang zijn");
        return id.substring(0, 2) + "-" + randomLetters(3) + "-" + randomDigits(1);
    }

    public Vehicle createVehicle(String brand) {
        String id = generateVehicleId();
        String licensePlate = generateVehicleLicense(id);
        return new Vehicle(id, licensePlate, VEHICLE_INFO_DB.get(brand));
    }

    // Test
    public static void main(String[] args) {
        VehicleRegistry registry = new VehicleRegistry();
        for (int i = 0; i < 10; i++)
            System.out.println(registry.generateVehicleLicense(registry.generateVehicleId()));
    }
}
