public abstract class MotorVehicle implements Vehicle {
    String licensePlate
    String brand
    int mileage
    void start() {
        System.out.println("Vehicle [" + brand + "] is starting.");
    }
    void stop() {
        System.out.println("Vehicle [" + brand + "] is stopping.");
    }
    double abstract getFuelConsumption();
    int getMileage() {
        return mileage;
    }

}