package SingleResponsibility.Assignment.EmployeeManagementSystem;

public class SalaryCalculator {
    public double calculateSalary(Employee employee) {
        // Assuming a simple salary calculation
        return employee.getBaseSalary() + (employee.getYearsOfExperience() * 1000);
    }
}
