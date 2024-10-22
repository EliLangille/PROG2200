package SingleResponsibility.Assignment.EmployeeManagementSystem;

public class Employee {
    private String name;
    private double baseSalary;
    private int yearsOfExperience;

    public Employee(String name, double baseSalary, int yearsOfExperience) {
        this.name = name;
        this.baseSalary = baseSalary;
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }
}

