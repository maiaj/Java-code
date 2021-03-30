package cz.vse.java.du1;

import java.util.ArrayList;

public class EmployeeDatabaseImpl implements IEmployeeDatabase {

    private ArrayList<IEmployee> data;

    public EmployeeDatabaseImpl() {
        this.data = new ArrayList<IEmployee>();
    }

    @Override
    public int getNumberOfEmployees() {
        return this.data.size();
    }

    @Override
    public void addEmployee(IEmployee employee) {
        this.data.add(employee);
    }

    @Override
    public double getSalarySum() {
        double result = 0;

        for (IEmployee datum : this.data) {
            result += datum.getSalary();
        }
        return result;
    }
}
