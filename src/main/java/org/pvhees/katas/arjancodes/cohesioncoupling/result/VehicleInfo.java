package org.pvhees.katas.arjancodes.cohesioncoupling.result;

public class VehicleInfo {
    private final String brand;
    private final int catalogPrice;
    private final boolean electric;

    public VehicleInfo(String brand, int catalogPrice, boolean electric) {
        this.brand = brand;
        this.catalogPrice = catalogPrice;
        this.electric = electric;
    }

    public String getBrand() {
        return brand;
    }

    public int getCatalogPrice() {
        return catalogPrice;
    }

    public boolean isElectric() {
        return electric;
    }

    @Override
    public String toString() {
        return "VehicleInfo{" +
                "brand='" + brand + '\'' +
                ", catalogPrice=" + catalogPrice +
                ", electric=" + electric +
                '}';
    }
}
