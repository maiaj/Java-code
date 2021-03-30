import model.Owner;
import model.Vehicle;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Owner owner1 = new Owner(1, "Mariola", "Kadlubiec");
        Owner owner2 = new Owner(2, "Jakub", "Kadlubiec");
        Owner owner3 = new Owner(3, "Michal", "Polak");
        Vehicle vehicle1 = new Vehicle("AAA1234", "Skoda", "Octavia", 2005, owner1);
        Vehicle vehicle2 = new Vehicle("AAA1235", "Volkswagen", "Passat", 2010, owner1);
        Vehicle vehicle3 = new Vehicle("AAA1236", "Ford", "Mustang", 2017, owner2);

        VehicleRegistry vehicleRegistry = new VehicleRegistry();

        vehicleRegistry.addVehicle(vehicle1);
        vehicleRegistry.addVehicle(vehicle2);
        vehicleRegistry.addVehicle(vehicle3);

        //Change owner
        vehicleRegistry.changeOwner("AAA1234", owner2);
        vehicleRegistry.changeOwner("AAA1234", owner3);
        String newOwner = vehicle1.getOwner().getName() + " " + vehicle1.getOwner().getSurname();

        List<Owner> oldOwners = vehicle1.getPreviousOwners();
        String oldOwnersString = "";

        for (Owner owner : oldOwners) {
            String ownersList = owner.getName() + " " + owner.getSurname() + ", ";
            oldOwnersString = oldOwnersString + ownersList;
        }

        System.out.println("The new owner is: " + newOwner + ", while the previous owners were: " + oldOwnersString);

        //Get number of vehicles
        System.out.println("There are " + vehicleRegistry.getNumberOfVehicles() + " vehicles in the registry.");

        //Get average age of vehicle
        System.out.println("The average vehicle age is " + vehicleRegistry.getAvgVehicleAge() + " years.");

    }
}