package cz.vse.java.du1;

import java.util.Objects;

public class EmployeeImpl implements IEmployee {
    private String name;
    private double salary;

    public EmployeeImpl(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    @Override
    public double getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeImpl employee = (EmployeeImpl) o;

        if (Double.compare(employee.salary, salary) != 0) return false;
        return Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        temp = Double.doubleToLongBits(salary);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}

