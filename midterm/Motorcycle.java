public class Motorcycle extends MotorVehicle {
    private boolean hasSidecar;

    public Motorcycle(String licensePlate, String brand, boolean hasSidecar) {
        this.licensePlate = licensePlate;
        this.brand = brand;
        this.hasSidecar = hasSidecar;
    }

    @Override
    double getFuelConsumption() {
        return ((double) mileage) / 100 * 3.5;
    }

    @Override
    public String getType() {
        return "Motorcycle";
    }

    @Override
    public double calculateMaintenanceCost(int distance) {
        return ((double) distance) * 0.03;
    }
}