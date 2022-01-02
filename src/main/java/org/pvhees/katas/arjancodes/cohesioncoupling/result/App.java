package org.pvhees.katas.arjancodes.cohesioncoupling.result;

public class App {
    // Video: https://www.youtube.com/watch?v=eiDyK_ofPPM&t=2s
    public Vehicle registerVehicle(String brand) {
        VehicleRegistry registry = new VehicleRegistry();
        return registry.createVehicle(brand);
    }

    public static void main(String[] args) {
        App app = new App();
        Vehicle vehicle = app.registerVehicle("BMW");
        System.out.println(vehicle.toString());
    }
}
