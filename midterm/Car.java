public class Car extends MotorVehicle {
    private int numDoors;
    public Car(String licensePlate, String brand, int numDoors) {
        this.licensePlate = licensePlate;
        this.brand = brand;
        this.numDoors = numDoors;
    }

    @Override
    double getFuelConsumption() {
        return ((double) mileage) / 100 * 8.5;
    }

    @Override
    public String getType() {
        return "Car";
    }

    @Override
    public double calculateMaintenanceCost(int distance) {
        return ((double) distance) * 0.05;
    }
}