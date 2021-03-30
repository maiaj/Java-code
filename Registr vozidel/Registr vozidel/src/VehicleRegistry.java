import model.Owner;
import model.Vehicle;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;


public class VehicleRegistry implements IVehicleRegistry {

    private ArrayList<Vehicle> data;

    public VehicleRegistry() {
        this.data = new ArrayList<Vehicle>();
    }

    @Override
    public int getNumberOfVehicles() {
        return this.data.size();
    }

    @Override
    public void addVehicle(Vehicle vehicle) {
        this.data.add(vehicle);
    }

    @Override
    public void changeOwner(String plateNumber, Owner owner) {
        for (Vehicle vehicle : this.data) {
            if (plateNumber == vehicle.getPlateNumber()) {
                vehicle.setOwner(owner);
            }
        }
    }

    @Override
    public long getAvgVehicleAge() {
        long sumOfAge = 0;
        for (Vehicle vehicle : this.data) {
            long vehicleAge = LocalDate.now().getYear() - vehicle.getManufactureYear();
            sumOfAge = sumOfAge + vehicleAge;
        }
        return sumOfAge / this.data.size();
    }
}
