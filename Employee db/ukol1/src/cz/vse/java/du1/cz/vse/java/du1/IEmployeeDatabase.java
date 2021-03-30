package cz.vse.java.du1;

/**
 * Databaze zamestnancu.
 */
public interface IEmployeeDatabase {

    /**
     * Metoda vrati pocet zamestnancu v databazi.
     * @return pocet
     */
    int getNumberOfEmployees();

    /**
     * Metoda vlozi zamestnance do databaze.
     * 
     * @param employee zamestnanec
     */
    void addEmployee(IEmployee employee);

    /**
     * Metoda vrati sumu platu vsech zamestnancu.
     * @return celkovy plat
     */
    double getSalarySum();
}
