package model;

import java.util.ArrayList;
import java.util.List;

public class Vehicle {
    private String plateNumber;
    private String manufacturer;
    private String model;
    private int manufactureYear;
    private Owner owner;
    private List<Owner> previousOwners;

    public Vehicle(String plateNumber, String manufacturer, String model, int manufactureYear, Owner owner) {
        this.plateNumber = plateNumber;
        this.manufacturer = manufacturer;
        this.model = model;
        this.manufactureYear = manufactureYear;
        this.owner = owner;
        this.previousOwners = new ArrayList<>();
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public int getManufactureYear() {
        return manufactureYear;
    }

    public Owner getOwner() { return owner; }

    public void setOwner(Owner owner) {
        this.previousOwners.add(this.owner);
        this.owner = owner;
    }

    public List<Owner> getPreviousOwners() {
        return previousOwners;
    }

    public void setPreviousOwners(List<Owner> previousOwners) {
        this.previousOwners = previousOwners;
    }
}
