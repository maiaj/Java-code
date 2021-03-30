import model.Owner;
import model.Vehicle;

public interface IVehicleRegistry {

    //    Počet vozidel v registru
    int getNumberOfVehicles();

    //     Vložní nového vozidla (vstupem je vozidlo a majitel)
    void addVehicle(Vehicle vehicle);

    //     Přeregistrace vozidla (vstupem je SPZ a nový majitel)
    void changeOwner(String plateNumber, Owner owner);

    //    Výpočet průměrného roku výroby (za bonusový půl bod můžete spočítat průměrné stáří)
    long getAvgVehicleAge();
}
