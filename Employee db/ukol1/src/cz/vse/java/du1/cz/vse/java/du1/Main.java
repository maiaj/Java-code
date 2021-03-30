package cz.vse.java.du1;

public class Main {

    public static void main(String[] args) {
	// write your code here
        EmployeeDatabaseImpl employeeDatabase = new EmployeeDatabaseImpl();
        EmployeeImpl employee1 = new EmployeeImpl("Mariola", 10000);
        EmployeeImpl employee2 = new EmployeeImpl("Jakub", 15000);

        employeeDatabase.addEmployee(employee1);
        employeeDatabase.addEmployee(employee2);

        System.out.println(employeeDatabase.getNumberOfEmployees());
    }
}
