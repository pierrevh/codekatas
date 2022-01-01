package org.pvhees.katas.arjancodes.cohesioncoupling;

public class Vehicle {
    private final String id;
    private final String licensePlate;
    private final VehicleInfo info;

    public Vehicle(String id, String licensePlate, VehicleInfo info) {
        this.id = id;
        this.licensePlate = licensePlate;
        this.info = info;
    }

    public float payableTax() {
        float tax = 0.05f;
        if (info.isElectric()) {
            tax = 0.02f;
        }
        return info.getCatalogPrice() * tax;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id='" + id + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                ", info=" + info +
                ", payableTax=" + payableTax() +
                '}';
    }
}
