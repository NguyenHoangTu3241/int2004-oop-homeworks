public abstract class MotorVehicle implements Vehicle {
    protected String licensePlate;
    protected String brand;
    protected int mileage;

    public void start() {
        System.out.println("Vehicle [" + brand + "] is starting.");
    }

    public void stop() {
        System.out.println("Vehicle [" + brand + "] is stopping.");
    }

    abstract double getFuelConsumption();

    public int getMileage() {
        return mileage;
    }

    public String getBrand() {
        return brand;
    }

    public void drive(int distance) {
        mileage += distance;
    }

    public String getLicensePlate() {
        return licensePlate;
    }
}