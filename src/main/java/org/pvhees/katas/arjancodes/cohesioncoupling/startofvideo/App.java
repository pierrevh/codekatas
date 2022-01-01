package org.pvhees.katas.arjancodes.cohesioncoupling.startofvideo;

public class App {
    // Video: https://www.youtube.com/watch?v=eiDyK_ofPPM&t=2s
    public void registerVehicle(String brand) {
        VehicleRegistry registry = new VehicleRegistry();
        String vehicleId = registry.generateVehicleId();

        String licensePlate = registry.generateVehicleLicense(vehicleId);
        int catalogPrice = 0;
        if ("Tesla".equalsIgnoreCase(brand)) {
            catalogPrice = 60000;
        } else if ("Volvo".equalsIgnoreCase(brand)) {
            catalogPrice = 35000;
        } else if ("BMW".equalsIgnoreCase(brand)) {
            catalogPrice = 45000;
        }
        float tax = 0.05f;
        if ("Tesla".equalsIgnoreCase(brand) || "Volvo".equalsIgnoreCase(brand)) {
            tax = 0.02f;
        }
        float payableTax = catalogPrice * tax;

        System.out.println("Registration complete for:");
        System.out.println("Brand = " + brand);
        System.out.println("VehicleId = " + vehicleId);
        System.out.println("Licenseplate= " + licensePlate);
        System.out.println("payableTax = " + payableTax);
    }

    public static void main(String[] args) {
        App app = new App();
        app.registerVehicle("BMW");
    }
}
