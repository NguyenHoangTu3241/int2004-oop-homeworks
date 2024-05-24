import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class FleetManagement {
    private List<Vehicle> vehicles;

    public FleetManagement() {
        vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void removeVehicle(String licensePlate) {
        Vehicle vehicle = findVehicleByLicensePlate(licensePlate);
        vehicles.remove(vehicle);
    }

    public Vehicle findVehicleByLicensePlate(String licensePlate) {
        for (Vehicle vehicle : vehicles) {
            if (((MotorVehicle) vehicle).getLicensePlate() == licensePlate) {
                return vehicle;
            }
        }
        return null;
    }

    public double calculateTotalFuelConsumption() {
        double total = 0;
        for (Vehicle vehicle : vehicles) {
            total += ((MotorVehicle) vehicle).getFuelConsumption();
        }
        return total;
    }

    public int getTotalMileage() {
        int total = 0;
        for (Vehicle vehicle : vehicles) {
            total += ((MotorVehicle) vehicle).getMileage();
        }
        return total;
    }

    public double calculateTotalMaintenanceCost(int distance) {
        double total = 0;
        for (Vehicle vehicle : vehicles) {
            total += vehicle.calculateMaintenanceCost(distance);
        }
        return total;
    }

    public List<Vehicle> sortVehiclesByMileage() {
        Vehicle[] a = new Vehicle[vehicles.size()];
        for (int i = 0; i < vehicles.size(); i++) {
            a[i] = vehicles.get(i);
        }
        Vehicle[] aux = a;

        MergeSort(a, aux, 0, vehicles.size() - 1);

        return Arrays.stream(a).toList();
    }

    public List<Vehicle> sortVehiclesByMileage2() {
        Vehicle[] a = new Vehicle[vehicles.size()];
        for (int i = 0; i < vehicles.size(); i++) {
            a[i] = vehicles.get(i);
        }
        Vehicle[] aux = a;

        MergeSort2(a, aux, 0, vehicles.size() - 1);

        return Arrays.stream(a).toList();
    }

    Vehicle findVehicleWithMaxMileage() {
        Vehicle v = null;
        int maxMilage = 0;
        for (Vehicle vehicle : vehicles) {
            int milage = ((MotorVehicle) vehicle).getMileage();
            if (milage > maxMilage) {
                v = vehicle;
                maxMilage = milage;
            }
        }
        return v;
    }

    void MergeSort(Vehicle[] a, Vehicle[] aux, int left, int right) {
        if (left >= right) return;
        int middle = (left + right) / 2;
        MergeSort(a, aux, left, middle);
        MergeSort(a, aux, middle + 1, right);
        Merge(a, aux, left, middle, right);
    }

    void MergeSort2(Vehicle[] a, Vehicle[] aux, int left, int right) {
        if (left >= right) return;
        int middle = (left + right) / 2;
        MergeSort2(a, aux, left, middle);
        MergeSort2(a, aux, middle + 1, right);
        Merge2(a, aux, left, middle, right);
    }

    void Merge(Vehicle[] a, Vehicle[] aux, int left, int middle, int right) {
        for (int h = left; h <= right; h++) {
            aux[h] = a[h];
        }
        int i = left, j = middle + 1;
        int k = left;
        while (i <= middle && j <= right) {
            if (moreMileage(aux[i], aux[j])) {
                a[k] = aux[i];
                i++;
            } else {
                a[k] = aux[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            a[k] = aux[i];
            i++;
            k++;
        }
        while (j <= right) {
            a[k] = aux[j];
            j++;
            k++;
        }
    }

    void Merge2(Vehicle[] a, Vehicle[] aux, int left, int middle, int right) {
        for (int h = left; h <= right; h++) {
            aux[h] = a[h];
        }
        int i = left, j = middle + 1;
        int k = left;
        while (i <= middle && j <= right) {
            if (moreBandAndMileage(aux[i], aux[j])) {
                a[k] = aux[i];
                i++;
            } else {
                a[k] = aux[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            a[k] = aux[i];
            i++;
            k++;
        }
        while (j <= right) {
            a[k] = aux[j];
            j++;
            k++;
        }
    }

    private boolean moreMileage(Vehicle a, Vehicle b) {
        return ((MotorVehicle) a).getMileage() >= ((MotorVehicle) b).getMileage();
    }

    private boolean moreBandAndMileage(Vehicle a, Vehicle b) {
        if (Objects.equals(((MotorVehicle) a).getBrand(), ((MotorVehicle) b).getBrand()))
            return ((MotorVehicle) a).getMileage() >= ((MotorVehicle) b).getMileage();
        return ((MotorVehicle) a).getBrand().compareTo(((MotorVehicle) b).getBrand()) >= 0;
    }
}