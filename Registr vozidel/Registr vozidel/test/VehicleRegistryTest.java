import model.Owner;
import model.Vehicle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleRegistryTest {

    @Test
    public void addVehicle() {
        IVehicleRegistry vehicleRegistry = new VehicleRegistry();
        vehicleRegistry.addVehicle(new Vehicle("A", "A", "A", 1, new Owner(1, "A", "A")));
        vehicleRegistry.addVehicle(new Vehicle("B", "B", "B", 2, new Owner(2, "B", "B")));

        assertEquals(2, vehicleRegistry.getNumberOfVehicles());
    }

    @Test
    public void getNumberOfVehicles() {
        IVehicleRegistry vehicleRegistry = new VehicleRegistry();
        vehicleRegistry.addVehicle(new Vehicle("A", "A", "A", 1, new Owner(1, "A", "A")));

        assertEquals(1, vehicleRegistry.getNumberOfVehicles());
    }

    @Test
    public void changeOwner() {
        IVehicleRegistry vehicleRegistry = new VehicleRegistry();
        Owner oldOwner = new Owner(1, "A", "B");
        Vehicle vehicle = new Vehicle("A", "A", "A", 1, oldOwner);
        vehicleRegistry.addVehicle(vehicle);
        Owner newOwner = new Owner(2, "C", "D");
        vehicleRegistry.changeOwner("A", newOwner);

        assertEquals(newOwner, vehicle.getOwner());
    }

    @Test
    public void getAvgVehicleAge() {
        IVehicleRegistry vehicleRegistry = new VehicleRegistry();
        vehicleRegistry.addVehicle(new Vehicle("A", "A", "A", 2016, new Owner(1, "A", "A")));
        vehicleRegistry.addVehicle(new Vehicle("B", "B", "B", 2011, new Owner(2, "B", "B")));

        assertEquals(7, vehicleRegistry.getAvgVehicleAge());
    }

}